package ru.plifis.nbasim.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SkillDto {
    private Long id;
    private Byte shooting_dribble;
    private Byte shooting_off_dribble;
    private Byte standing_dunk;
    private Byte drive_dunk;
    private Byte fade_away;
    private Byte post_hook;
    private Byte contest_shoot;
    private Byte three_point;
    private Byte free_throw;
    private Byte drive;
    private Byte pass_accuracy;
    private Byte pass_vision;
    private Byte dribbling;
    private Byte defence_rebound;
    private Byte offense_rebound;
    private Byte interior_defence;
    private Byte perimeter_defence;
    private Byte steal;
    private Byte block;
    private Byte speed;
    private Byte acceleration;
    private Byte durability;
    private Byte jump;
}