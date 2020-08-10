package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private ElementsCollection buttons = $$("[role=button]");
    private SelenideElement byuButton = buttons.first();
    private SelenideElement creditButton = $(byText("Купить в кредит"));
    private SelenideElement continueButton = $(byText("Продолжить"));

    private ElementsCollection fields = $$(".input__control");
    private SelenideElement numberField = $("[maxlength='19']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = fields.get(3);
    private SelenideElement cvvField = $("[maxlength='3']");

    public void payByCard() {
        byuButton.click();
    }

    public void creditByCard() {
        creditButton.click();
    }

    public void fillForm(DataHelper.Number Number, DataHelper.Month Month, DataHelper.Year Year, DataHelper.Owner Owner, DataHelper.Cvv Cvv) {
        numberField.sendKeys(Number.getNumber());
        monthField.sendKeys(Month.getMonth());
        yearField.sendKeys(Year.getYear());
        ownerField.sendKeys(Owner.getOwner());
        cvvField.sendKeys(Cvv.getCvv());
        continueButton.click();
    }
}
