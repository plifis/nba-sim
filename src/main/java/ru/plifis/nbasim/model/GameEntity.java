package ru.plifis.nbasim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import ru.plifis.nbasim.model.enums.GameTypeEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "games")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "home_team_id")
    private TeamEntity HomeTeamEntity;

    @OneToOne
    @JoinColumn(name = "home_statistic_entity")
    private StatisticEntity HomeStatisticEntity;

    @OneToOne
    @JoinColumn(name = "away_team_id")
    private TeamEntity AwayTamEntity;

    @OneToOne
    @JoinColumn(name = "away_statistic_entity")
    private StatisticEntity AwayStatisticEntity;

    @Enumerated(EnumType.STRING)
    private GameTypeEnum gameTypeName;

    @ManyToOne
    @JoinColumn(name = "rounds_id", nullable = true)
    private RoundPOEntity round;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GameEntity that = (GameEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}