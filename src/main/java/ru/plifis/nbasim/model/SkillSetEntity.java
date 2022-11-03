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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillSetEntity that = (SkillSetEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(shooting_dribble, that.shooting_dribble) && Objects.equals(shooting_off_dribble, that.shooting_off_dribble)
                && Objects.equals(standing_dunk, that.standing_dunk) && Objects.equals(drive_dunk, that.drive_dunk)
                && Objects.equals(fade_away, that.fade_away) && Objects.equals(post_hook, that.post_hook)
                && Objects.equals(contest_shoot, that.contest_shoot) && Objects.equals(three_point, that.three_point)
                && Objects.equals(free_throw, that.free_throw) && Objects.equals(drive, that.drive)
                && Objects.equals(pass_accuracy, that.pass_accuracy) && Objects.equals(pass_vision, that.pass_vision)
                && Objects.equals(dribbling, that.dribbling) && Objects.equals(defence_rebound, that.defence_rebound)
                && Objects.equals(offense_rebound, that.offense_rebound) && Objects.equals(interior_defence, that.interior_defence)
                && Objects.equals(perimeter_defence, that.perimeter_defence) && Objects.equals(steal, that.steal)
                && Objects.equals(block, that.block) && Objects.equals(speed, that.speed) && Objects.equals(acceleration, that.acceleration)
                && Objects.equals(durability, that.durability) && Objects.equals(jump, that.jump);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shooting_dribble, shooting_off_dribble, standing_dunk, drive_dunk, fade_away, post_hook,
                contest_shoot, three_point, free_throw, drive, pass_accuracy, pass_vision, dribbling, defence_rebound,
                offense_rebound, interior_defence, perimeter_defence, steal, block, speed, acceleration, durability, jump);
    }
}
