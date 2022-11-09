package ru.plifis.nbasimmodel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.plifis.nbasimmodel.model.enums.MarketEnum;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TeamDto {
    private Long id;
    private String name;
    private String city;
    private String arena;
    private MarketEnum marketSize;
    @ToString.Exclude
    private List<PlayerDto> playersList;
    private BigDecimal salaryCap;
    private BigDecimal salaryCurrent;
}