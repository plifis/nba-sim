package ru.plifis.nbasim.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.RoundEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "rounds")
public class RoundPOEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoundEnum roundEnum;

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

    @OneToMany(mappedBy = "games")
    private List<GameEntity> gameEntityList;
}