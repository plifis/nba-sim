package ru.plifis.nbasim.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import ru.plifis.nbasimmodel.model.enums.RoundEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "rounds")
public class RoundPOEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoundEnum roundName;

    private Integer winForNextRound;
    private Integer homeTeamEntityWins;
    private Integer awayTeamEntityWins;

    /**
     * Команда получившая преимущество домашней площадки
     * по итогам регулярного сезона
     */
    @OneToOne
    @JoinColumn(name = "first_team_id")
    private TeamEntity firstTeamEntity;

    @OneToOne
    @JoinColumn(name = "second_team_id")
    private TeamEntity secondTeamEntity;

    @OneToOne
    @JoinColumn(name = "winner_id")
    private TeamEntity winner = null;

    @OneToMany(mappedBy = "round")
    @ToString.Exclude
    private List<GameEntity> rounds;

    @ManyToOne
    @JoinColumn(name = "playoff_id")
    private PlayOffEntity playOff;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoundPOEntity that = (RoundPOEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}