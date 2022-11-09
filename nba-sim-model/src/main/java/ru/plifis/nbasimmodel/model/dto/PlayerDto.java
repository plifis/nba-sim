package ru.plifis.nbasimmodel.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.plifis.nbasimmodel.model.enums.PositionEnum;

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

    @JsonIgnore
    @ToString.Exclude
    private TeamDto team;
    private ContractDto contract;
    private SkillDto skillsets;
    private List<BadgeDto> badgeList;
}
