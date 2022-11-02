package ru.plifis.nbasim.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.SkillEnum;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SkillDto {
    private Long id;
    private SkillEnum skillName;
    private Long rating;
}