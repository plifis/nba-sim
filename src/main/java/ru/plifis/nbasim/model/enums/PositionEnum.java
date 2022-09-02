package ru.plifis.nbasim.model.enums;

public enum PositionEnum {
    CENTER("CENTER"),
    POWER_FORWARD("POWER FORWARD"),
    SMALL_FORWARD("SMALL_FORWARD"),
    SHOOTING_GUARD("SHOOTING_GUARD"),
    POINT_GUARD("POINT_GUARD");

    private final String value;

    PositionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}