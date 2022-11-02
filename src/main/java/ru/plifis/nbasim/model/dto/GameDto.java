package ru.plifis.nbasim.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.StatisticEntity;
import ru.plifis.nbasim.model.TeamEntity;
import ru.plifis.nbasim.model.enums.GameTypeEnum;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GameDto {
    private TeamEntity HomeTeamEntity;
    private StatisticEntity HomeStatisticEntity;
    private TeamEntity AwayTamEntity;
    private StatisticEntity AwayStatisticEntity;
    private GameTypeEnum gameTypeEnum;
}
