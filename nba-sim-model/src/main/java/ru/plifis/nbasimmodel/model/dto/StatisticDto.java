package ru.plifis.nbasimmodel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class StatisticDto {
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
