package ru.plifis.nbasim.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
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
    private Integer id;

    @Column(name = "shooting_dribble")
    private Byte shootingDribble = 0;

    @Column(name = "shooting_off_dribble")
    private Byte shootingOffDribble = 0;

    @Column(name = "standing_dunk")
    private Byte standingDunk = 0;

    @Column(name = "drive_dunk")
    private Byte driveDunk = 0;

    @Column(name = "fade_away")
    private Byte fadeAway = 0;

    @Column(name = "post_hook")
    private Byte postHook = 0;

    @Column(name = "contest_shoot")
    private Byte contestShoot = 0;

    @Column(name = "three_point")
    private Byte threePoint = 0;

    @Column(name = "free_throw")
    private Byte freeThrow  = 0;

    @Column(name = "drive")
    private Byte drive = 0;

    @Column(name = "pass_accuracy")
    private Byte passAccuracy = 0;

    @Column(name = "pass_vision")
    private Byte passVision = 0;

    @Column(name = "dribbling")
    private Byte dribbling = 0;

    @Column(name = "defence_rebound")
    private Byte defenceRebound = 0;

    @Column(name = "offense_rebound")
    private Byte offenseRebound = 0;

    @Column(name = "interior_defence")
    private Byte interiorDefence = 0;

    @Column(name = "perimeter_defence")
    private Byte perimeterDefence = 0;

    @Column(name = "steal")
    private Byte steal = 0;

    @Column(name = "block")
    private Byte block = 0;

    @Column(name = "speed")
    private Byte speed = 0;

    @Column(name = "acceleration")
    private Byte acceleration = 0;

    @Column(name = "durability")
    private Byte durability = 0;

    @Column(name = "jump")
    private Byte jump = 0;

    @Column(name = "total_rating")
    private Integer totalRating = 0;

    public void setTotalRating() {
        this.totalRating = shootingDribble + shootingOffDribble + standingDunk + driveDunk
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
