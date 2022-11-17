package ru.plifis.nbasimmodel.model.dto;

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
    private Byte shootingDribble;
    private Byte shootingOffDribble;
    private Byte standingDunk;
    private Byte driveDunk;
    private Byte fadeAway;
    private Byte postHook;
    private Byte contestShoot;
    private Byte threePoint;
    private Byte freeThrow;
    private Byte drive;
    private Byte passAccuracy;
    private Byte passVision;
    private Byte dribbling;
    private Byte defenceRebound;
    private Byte offenseRebound;
    private Byte interiorDefence;
    private Byte perimeterDefence;
    private Byte steal;
    private Byte block;
    private Byte speed;
    private Byte acceleration;
    private Byte durability;
    private Byte jump;

    public Integer getTotalRating() {
        return shootingDribble + shootingOffDribble + standingDunk + driveDunk
                + fadeAway + postHook + contestShoot + threePoint + freeThrow + drive + passAccuracy
                + passVision + dribbling + defenceRebound + offenseRebound + interiorDefence + perimeterDefence
                + steal + block + speed + acceleration + durability + jump;
    }
}