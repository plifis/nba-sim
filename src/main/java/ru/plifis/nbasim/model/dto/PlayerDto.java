package ru.plifis.nbasim.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.PositionEnum;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PlayerDto {
    private Long id;
    private String name;
    private String surname;
    private PositionEnum position;
    private LocalDate birthDate;
    private String birthPlace;
    private String birthCountry;
    private Double height;
    private Double weight;

    @JsonProperty("team")
    private TeamDto team;
    @JsonProperty("contract")
    private ContractDto contract;
    @JsonProperty("skill")
    private SkillDto skill;
    @JsonProperty("badgeList")
    private List<BadgeDto> badgeList;
}
