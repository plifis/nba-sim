package ru.plifis.nbasim.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.BadgeEnum;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BadgeDto {
    private Long id;
    private BadgeEnum badgeEnum;

    @JsonProperty("skills")
    private List<SkillDto> skills;
}
