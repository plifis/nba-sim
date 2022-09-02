package ru.plifis.nbasim.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.GameTypeEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "games")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "home_team_id")
    private TeamEntity HomeTeamEntity;

    @OneToOne
    @JoinColumn(name = "away_team_id")
    private TeamEntity AwayTamEntity;

    @Enumerated(EnumType.STRING)
    private GameTypeEnum gameTypeEnum;
}