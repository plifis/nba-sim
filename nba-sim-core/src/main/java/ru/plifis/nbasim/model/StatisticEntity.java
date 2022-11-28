package ru.plifis.nbasim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

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
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "statistics")
public class StatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "points_total")
    private Integer pointsTotal;

    @Column(name = "assists_total")
    private Integer assistsTotal;

    @Column(name = "off_rebounds_total")
    private Integer offReboundsTotal;

    @Column(name = "def_rebounds_total")
    private Integer defReboundsTotal;

    @Column(name = "rebounds_total")
    private Integer reboundsTotal;

    @Column(name = "steals_total")
    private Integer stealsTotal;

    @Column(name = "blocks_total")
    private Integer blocksTotal;

    @Column(name = "games_played_total")
    private Integer gamesPlayedTotal;

    @Column(name = "game_start_total")
    private Integer gamesStartTotal;

    @Column(name = "points_per_game")
    private Double pointsPerGame;

    @Column(name = "assists_per_game")
    private Double assistsPerGame;

    @Column(name = "rebounds_per_game")
    private Double reboundPerGame;

    @Column(name = "steals_per_game")
    private Double stealsPerGame;

    @Column(name = "blocks_per_game")
    private Double blocksPerGame;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        StatisticEntity that = (StatisticEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
