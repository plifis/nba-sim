package ru.plifis.nbasim.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "player_statistic_season")
public class PlayerStatisticSeasonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "player_statistic_entity_id")
    private PlayerStatisticEntity playerStatisticEntity;

    @OneToOne
    @JoinColumn(name = "season_id")
    private SeasonEntity seasonEntity;

    private Integer pointsTotal;
    private Integer assistsTotal;
    private Integer offReboundsTotal;
    private Integer defReboundsTotal;
    private Integer reboundsTotal;
    private Integer stealsTotal;
    private Integer blocksTotal;
    private Integer gamesPlayedTotal;
    private Integer gamesStartTotal;

    private Double pointsPerGame;
    private Double assistsPerGame;
    private Double reboundPerGame;
    private Double stealsPerGame;
    private Double blocksPerGame;
}