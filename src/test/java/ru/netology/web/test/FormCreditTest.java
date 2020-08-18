package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.TablesHelper;
import ru.netology.web.page.PaymentPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormCreditTest {
    @BeforeAll
    public static void cleanTablesBefore() throws SQLException {
        TablesHelper.cleanData();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    public static void cleanTablesAfter() throws SQLException {
        TablesHelper.cleanData();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    private String approvedStatus = "APPROVED";
    private String declinedStatus = "DECLINED";

    @Nested
    public class PaymentOperationsTests {
        private DataHelper.Month month = DataHelper.getValidMonth();
        private DataHelper.Year year = DataHelper.getValidYear();
        private DataHelper.Owner owner = DataHelper.getValidOwner();
        private DataHelper.Cvv cvv = DataHelper.getValidCVV();

        @Test
        void shouldReceivePaymentWhenValidApprovedCard() throws SQLException {
            val number = DataHelper.getApprovedValidCard();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.successMessage();
            TablesHelper.compareCreditAndTransactionID();
            String expectedStatus = approvedStatus;
            String actualStatus = TablesHelper.getCreditStatus();
            assertEquals(expectedStatus, actualStatus);
        }

        @Test
        void shouldNotReceivePaymentWhenValidNotApprovedCard() throws SQLException {
            val number = DataHelper.getNotApprovedValidCard();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.failMessage();
            TablesHelper.compareCreditAndTransactionID();
            String expectedStatus = declinedStatus;
            String actualStatus = TablesHelper.getCreditStatus();
            Assertions.assertEquals(expectedStatus, actualStatus);
        }

        @Test
        void shouldNotReceivePaymentWhenOtherBankCard() throws SQLException {
            val number = DataHelper.getOtherBankCard();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.failMessage();
            TablesHelper.compareCreditAndTransactionID();
            String expectedStatus = declinedStatus;
            String actualStatus = TablesHelper.getCreditStatus();
            Assertions.assertEquals(expectedStatus, actualStatus);
        }
    }

    @Nested
    public class NumberFieldTests {
        private DataHelper.Month month = DataHelper.getValidMonth();
        private DataHelper.Year year = DataHelper.getValidYear();
        private DataHelper.Owner owner = DataHelper.getValidOwner();
        private DataHelper.Cvv cvv = DataHelper.getValidCVV();

        @Test
        void shouldNotReceivePaymentWhenValidApprovedCard() {
            val number = DataHelper.getEmptyCard();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenCardLess16() {
            val number = DataHelper.getInvalidCardFormatLess();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenCardIrrelevantSymbols() {
            val number = DataHelper.getInvalidCardFormatSymbols();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldReceiveOnly16SymbolsWhenCardMore16Symbols() throws SQLException {
            val number = DataHelper.getInvalidCardFormatMore();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.successMessage();
            TablesHelper.compareCreditAndTransactionID();
            String expectedStatus = approvedStatus;
            String actualStatus = TablesHelper.getCreditStatus();
            Assertions.assertEquals(expectedStatus, actualStatus);
        }
    }

    @Nested
    public class MonthFieldTests {
        private DataHelper.Number number = DataHelper.getApprovedValidCard();
        private DataHelper.Year year = DataHelper.getValidYear();
        private DataHelper.Owner owner = DataHelper.getValidOwner();
        private DataHelper.Cvv cvv = DataHelper.getValidCVV();

        @Test
        void shouldNotReceivePaymentWhenMonthEmpty() {
            val month = DataHelper.getEmptyMonth();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenInvalidMonthLess() {
            val month = DataHelper.getInvalidMonthLess();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongTermMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenInvalidMonthMore() {
            val month = DataHelper.getInvalidMonthMore();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongTermMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenMonth1Number() {
            val month = DataHelper.getInvalidFormatMonthLess();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenMonthIrrelevantSymbols() {
            val month = DataHelper.getInvalidSymbolsMonth();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldReceiveOnly2SymbolsWhenMonthMore2Symbols() throws SQLException {
            val month = DataHelper.getInvalidFormatMonthMore();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.successMessage();
            TablesHelper.compareCreditAndTransactionID();
            String expectedStatus = approvedStatus;
            String actualStatus = TablesHelper.getCreditStatus();
            Assertions.assertEquals(expectedStatus, actualStatus);
        }
    }

    @Nested
    public class YearFieldTests {
        DataHelper.Number number = DataHelper.getApprovedValidCard();
        DataHelper.Month month = DataHelper.getValidMonth();
        DataHelper.Owner owner = DataHelper.getValidOwner();
        DataHelper.Cvv cvv = DataHelper.getValidCVV();

        @Test
        void shouldNotReceivePaymentWhenYearEmpty() {
            val year = DataHelper.getEmptyYear();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenInvalidYearLess() {
            val year = DataHelper.getInvalidFormatYearLess();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenYearInPast() {
            val year = DataHelper.getEarlyYear();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.cardExpiredMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenYearIrrelevantSymbols() {
            val year = DataHelper.getIrrelevantSymbolsYear();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldReceiveOnly2SymbolsWhenYearMore2Symbols() throws SQLException {
            val year = DataHelper.getInvalidFormatYearMore();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.successMessage();
            TablesHelper.compareCreditAndTransactionID();
            String expectedStatus = approvedStatus;
            String actualStatus = TablesHelper.getCreditStatus();
            Assertions.assertEquals(expectedStatus, actualStatus);
        }
    }

    @Nested
    public class OwnerFieldTests {
        DataHelper.Number number = DataHelper.getApprovedValidCard();
        DataHelper.Month month = DataHelper.getValidMonth();
        DataHelper.Year year = DataHelper.getValidYear();
        DataHelper.Cvv cvv = DataHelper.getValidCVV();

        @Test
        void shouldNotReceivePaymentWhenOwnerEmpty() {
            val owner = DataHelper.getEmptyOwner();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenOwnerOneWord() {
            val owner = DataHelper.getInvalidLessOwner();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenOwnerThreeWords() {
            val owner = DataHelper.getInvalidMoreOwner();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenOwnerIrrelevantSymbols() {
            val owner = DataHelper.getIrrelevantSymbolsOwner();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenOwnerSmallLetters() {
            val owner = DataHelper.getSmallLettersOwner();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }
    }

    @Nested
    public class CVVFieldTests {
        DataHelper.Number number = DataHelper.getApprovedValidCard();
        DataHelper.Month month = DataHelper.getValidMonth();
        DataHelper.Year year = DataHelper.getValidYear();
        DataHelper.Owner owner = DataHelper.getValidOwner();

        @Test
        void shouldNotReceivePaymentWhenCVVEmpty() {
            val cvv = DataHelper.getEmptyCVV();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenCVV2Numbers() {
            val cvv = DataHelper.getInvalidLessCVV();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldNotReceivePaymentWhenIrrelevantSymbolsCVV() {
            val cvv = DataHelper.getInvalidSymbolsCVV();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.wrongFormatCardMessage();
        }

        @Test
        void shouldReceiveOnly3SymbolsWhenCVVMore3Symbols() throws SQLException {
            val cvv = DataHelper.getInvalidMoreCVV();
            open("http://localhost:8080");
            val paymentPage = new PaymentPage();
            paymentPage.creditByCard();
            paymentPage.fillForm(number, month, year, owner, cvv);
            paymentPage.successMessage();
            TablesHelper.compareCreditAndTransactionID();
            String expectedStatus = approvedStatus;
            String actualStatus = TablesHelper.getCreditStatus();
            Assertions.assertEquals(expectedStatus, actualStatus);
        }
    }
}
