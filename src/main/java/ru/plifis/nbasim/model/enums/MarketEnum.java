package ru.plifis.nbasim.model.enums;

public enum MarketEnum {
    BIGGER("BIGGER"),
    MIDDLE("MIDDLE"),
    SMALL("SMALL");

    private final String value;

    MarketEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}