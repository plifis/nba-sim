package ru.plifis.nbasim.model.enums;

public enum SkillEnum {
    SHOOTING_DRIBBLE("SHOOTING_DRIBBLE"),
    SHOOTING_OFF_DRIBBLE("SHOOTING_OFF_DRIBBLE"),
    STANDING_DUNK("STANDING_DUNK"),
    DRIVE_DUNK("DRIVE_DUNK"),
    FADE_AWAY("FADE_AWAY"),
    POST_HOOK("POST_HOOK"),
    CONTEST_SHOOT("CONTEST_SHOOT"),
    THREE_POINT("THREE_POINT"),
    FREE_THROW("FREE_THROW"),
    DRIVE("DRIVE"),
    PASS_ACCURACY("PASS_ACCURACY"),
    PASS_VISION("PASS_VISION"),
    DRIBBLING("DRIBBLING"),
    DEF_REBOUND("DEFENCE_REBOUND"),
    OFF_REBOUND("OFFENSE_REBOUND"),
    INTERIOR_DEFENCE("INTERIOR_DEFENCE"),
    PERIMETER_DEFENCE("PERIMETER_DEFENCE"),
    STEAL("STEAL"),
    BLOCK("BLOCK");

    private String value;

    SkillEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return value;
    }
}
