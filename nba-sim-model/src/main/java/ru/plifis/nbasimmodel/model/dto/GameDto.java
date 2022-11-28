package ru.plifis.nbasimmodel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasimmodel.model.enums.GameTypeEnum;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GameDto {
    private Integer id;
    private TeamDto homeTeam;
    private StatisticDto homeStatistic;
    private List<Integer> startLineupHomeTeamIds;
    private List<Integer> benchHomeTeamIds;
    private TeamDto awayTeam;
    private StatisticDto awayStatistic;
    private List<Integer> startLineupAwayTeamIds;
    private List<Integer> benchAwayTeamIds;
    private GameTypeEnum gameTypeEnum;
}