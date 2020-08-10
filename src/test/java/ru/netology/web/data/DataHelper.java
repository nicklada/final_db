package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class Number {
        private String Number;
    }

    public static Number getApprovedValidCard() {
        return new Number("4444444444444441");
    }

    public static Number getNotApprovedValidCard() {
        return new Number("4444444444444442");
    }

    public static Number getOtherBankCard() {
        return new Number("5336444444444442");
    }

    public static Number getEmptyCard() {
        return new Number("");
    }

    public static Number getInvalidCardFormatLess() {
        return new Number("444444444444444");
    }

    public static Number getInvalidCardFormatMore() {
        return new Number("44444444444444413");
    }

    public static Number getInvalidCardFormatSymbols() {
        return new Number("qwertyuiop@#$%^&");
    }

    @Value
    public static class Month {
        private String Month;
    }

    public static Month getValidMonth() {
        return new Month("08");
    }

    public static Month getEmptyMonth() {
        return new Month("");
    }

    public static Month getInvalidMonthLess() {
        return new Month("00");
    }

    public static Month getInvalidFormatMonthLess() {
        return new Month("8");
    }

    public static Month getInvalidFormatMonthMore() {
        return new Month("088");
    }

    public static Month getInvalidMonthMore() {
        return new Month("13");
    }

    public static Month getInvalidSymbolsMonth() {
        return new Month("q&");
    }

    @Value
    public static class Year {
        private String Year;
    }

    public static Year getValidYear() {
        return new Year("22");
    }

    public static Year getEmptyYear() {
        return new Year("");
    }

    public static Year getInvalidFormatYearLess() {
        return new Year("2");
    }

    public static Year getInvalidFormatYearMore() {
        return new Year("2022");
    }

    public static Year getEarlyYear() {
        return new Year("10");
    }

    public static Year getIrrelevantSymbolsYear() {
        return new Year("w%");
    }

    @Value
    public static class Owner {
        private String Owner;
    }

    public static Owner getValidOwner() {
        return new Owner("Ivan Ivanov");
    }

    public static Owner getEmptyOwner() {
        return new Owner("");
    }

    public static Owner getInvalidLessOwner() {
        return new Owner("Ivan");
    }

    public static Owner getInvalidMoreOwner() {
        return new Owner("Ivan Ivanovich Ivanov");
    }

    public static Owner getSmallLettersOwner() {
        return new Owner("ivan ivanov");
    }

    public static Owner getIrrelevantSymbolsOwner() {
        return new Owner("Ива& !@d$k^");
    }

    @Value
    public static class Cvv {
        private String Cvv;
    }

    public static Cvv getValidCVV() {
        return new Cvv("999");
    }

    public static Cvv getEmptyCVV() {
        return new Cvv("");
    }

    public static Cvv getInvalidLessCVV() {
        return new Cvv("99");
    }

    public static Cvv getInvalidMoreCVV() {
        return new Cvv("9999");
    }

    public static Cvv getInvalidSymbolsCVV() {
        return new Cvv("j@_");
    }


}
