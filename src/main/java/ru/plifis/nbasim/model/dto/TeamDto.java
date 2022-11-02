package ru.plifis.nbasim.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.MarketEnum;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TeamDto {
    private Long id;
    private String name;
    private String city;
    private String arena;
    private MarketEnum marketSize;
    private List<PlayerDto> playersList;
    private BigDecimal salaryCap;
    private BigDecimal salaryCurrent;
}