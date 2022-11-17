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
    private TeamDto homeTeam;
    private StatisticDto homeStatistic;
    private List<Long> startLineupHomeTeamIds;
    private List<Long> benchHomeTeamIds;
    private TeamDto awayTeam;
    private StatisticDto awayStatistic;
    private List<Long> startLineupAwayTeamIds;
    private List<Long> benchAwayTeamIds;
    private GameTypeEnum gameTypeEnum;
}