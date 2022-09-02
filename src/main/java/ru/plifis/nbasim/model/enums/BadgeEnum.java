package ru.plifis.nbasim.model.enums;

public enum BadgeEnum {
    FINISHER("FINISHER"),
    DUNKER("DUNKER"),
    CATCH_AND_SHOOT("CATCH_AND_SHOOT"),
    CORNER_SPECIALIST("CORNER_SPECIALIST"),
    CLUTCH_SHOOTER("CLUTCH_SHOOTER"),
    FADE_ACE("FADE_ACE"),
    ANKLE_BREAKER("ANKLE_BREAKER"),
    BALL_STIPPER("BALL_STIPPER"),
    BOX("BOX"),
    HUSTLER("HUSTLER"),
    REBOUND_CHASER("REBOUND_CHASER"),
    RIM_PROTECTOR("RIM_PROTECTOR");

    private String value;

    BadgeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return value;
    }
}
