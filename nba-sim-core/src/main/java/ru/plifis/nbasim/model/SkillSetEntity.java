package ru.plifis.nbasim.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "skillsets")
public class SkillSetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SkillSetEntity that = (SkillSetEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(shootingDribble, that.shootingDribble)
                && Objects.equals(shootingOffDribble, that.shootingOffDribble)
                && Objects.equals(standingDunk, that.standingDunk)
                && Objects.equals(driveDunk, that.driveDunk) && Objects.equals(fadeAway, that.fadeAway)
                && Objects.equals(postHook, that.postHook) && Objects.equals(contestShoot, that.contestShoot)
                && Objects.equals(threePoint, that.threePoint) && Objects.equals(freeThrow, that.freeThrow)
                && Objects.equals(drive, that.drive) && Objects.equals(passAccuracy, that.passAccuracy)
                && Objects.equals(passVision, that.passVision) && Objects.equals(dribbling, that.dribbling)
                && Objects.equals(defenceRebound, that.defenceRebound) && Objects.equals(offenseRebound, that.offenseRebound)
                && Objects.equals(interiorDefence, that.interiorDefence) && Objects.equals(perimeterDefence, that.perimeterDefence)
                && Objects.equals(steal, that.steal) && Objects.equals(block, that.block) && Objects.equals(speed, that.speed)
                && Objects.equals(acceleration, that.acceleration) && Objects.equals(durability, that.durability)
                && Objects.equals(jump, that.jump);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shootingDribble, shootingOffDribble, standingDunk, driveDunk, fadeAway, postHook,
                contestShoot, threePoint, freeThrow, drive, passAccuracy, passVision, dribbling, defenceRebound,
                offenseRebound, interiorDefence, perimeterDefence, steal, block, speed, acceleration, durability, jump);
    }
}
