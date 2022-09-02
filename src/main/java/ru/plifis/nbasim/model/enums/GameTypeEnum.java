package ru.plifis.nbasim.model.enums;

public enum GameTypeEnum {
    REGULAR_SEASON("REGULAR_SEASON"),
    PLAYOFFS("PLAYOFFS");

    private final String value;

    GameTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}