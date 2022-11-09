package ru.plifis.nbasimmodel.model.enums;

public enum RoundEnum {
    FIRST_ROUND("FIRST_ROUND"),
    SEMIFINAL_CONFERENCE("SEMIFINAL_CONFERENCE"),
    FINAL_CONFERENCE("FINAL_CONFERENCE"),
    FINAL_NBA("FINAL_NBA");

    private final String value;

    RoundEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
