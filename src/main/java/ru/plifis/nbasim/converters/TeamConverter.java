package ru.plifis.nbasim.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.plifis.nbasim.model.TeamEntity;
import ru.plifis.nbasim.model.dto.TeamDto;

@Service
public class TeamConverter {
    private ModelMapper modelMapper;

    public TeamConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TeamDto convertTeamEntityToTeamDto(TeamEntity teamEntity) {
        return modelMapper.map(teamEntity, TeamDto.class);
    }

    public TeamEntity convertTeamDtoToTeamEntity(TeamDto teamDto) {
        return modelMapper.map(teamDto, TeamEntity.class);
    }

    public TeamEntity updateTeamEntityFromTeamDto(TeamDto teamDto) {
        TeamEntity updateTeam = new TeamEntity();
        modelMapper.map(teamDto, updateTeam);
        return updateTeam;
    }
}