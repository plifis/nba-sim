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
    private Integer id;
    private Byte shootingDribble = 0;
    private Byte shootingOffDribble = 0;
    private Byte standingDunk = 0;
    private Byte driveDunk = 0;
    private Byte fadeAway = 0;
    private Byte postHook = 0;
    private Byte contestShoot = 0;
    private Byte threePoint = 0;
    private Byte freeThrow = 0;
    private Byte drive = 0;
    private Byte passAccuracy = 0;
    private Byte passVision = 0;
    private Byte dribbling = 0;
    private Byte defenceRebound = 0;
    private Byte offenseRebound = 0;
    private Byte interiorDefence = 0;
    private Byte perimeterDefence = 0;
    private Byte steal = 0;
    private Byte block = 0;
    private Byte speed = 0;
    private Byte acceleration = 0;
    private Byte durability = 0;
    private Byte jump = 0;
    private Integer totalRating = 0;

    public void setTotalRating() {
        this.totalRating = shootingDribble + shootingOffDribble + standingDunk + driveDunk
                + fadeAway + postHook + contestShoot + threePoint + freeThrow + drive + passAccuracy
                + passVision + dribbling + defenceRebound + offenseRebound + interiorDefence + perimeterDefence
                + steal + block + speed + acceleration + durability + jump;
    }
}