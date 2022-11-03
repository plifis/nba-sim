package ru.plifis.nbasim.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.PositionEnum;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PlayerDto {
    private Long id;
    private String name;
    private String surname;
    private PositionEnum position;
    private Date birthDate;
    private String birthPlace;
    private String birthCountry;
    private Double height;
    private Double weight;

    @JsonProperty("team")
    private TeamDto team;
    @JsonProperty("contract")
    private ContractDto contract;
    @JsonProperty("skillsets")
    private SkillDto skillsets;
    @JsonProperty("badgeList")
    private List<BadgeDto> badgeList;
}
