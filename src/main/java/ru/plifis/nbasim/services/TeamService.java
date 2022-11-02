package ru.plifis.nbasim.services;

import org.springframework.stereotype.Service;
import ru.plifis.nbasim.converters.TeamConverter;
import ru.plifis.nbasim.model.TeamEntity;
import ru.plifis.nbasim.model.dto.TeamDto;
import ru.plifis.nbasim.repository.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamConverter teamConverter;

    public TeamService(TeamRepository teamRepository, TeamConverter teamConverter) {
        this.teamRepository = teamRepository;
        this.teamConverter = teamConverter;
    }

    public TeamDto findTeamById(Long id) {
        TeamEntity teamEntity = teamRepository.findTeamEntityById(id);
        return teamConverter.convertTeamEntityToTeamDto(teamEntity);
    }

    public Long createTeam(TeamDto teamDto) {
        var teamEntity = teamConverter.convertTeamDtoToTeamEntity(teamDto);
        return teamRepository.save(teamEntity).getId();
    }

    public List<TeamDto> finAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamConverter::convertTeamEntityToTeamDto).collect(Collectors.toList());
    }

    public TeamDto updateTeam(Long id, TeamDto teamDto) {
        TeamEntity teamEntity = teamRepository.findTeamEntityById(id);
        if (teamEntity == null) {
            throw new IllegalArgumentException(String.format("id %s not found", id));
        }
        teamEntity = teamConverter.updateTeamEntityFromTeamDto(teamDto);
        teamEntity =  teamRepository.save(teamEntity);
        return teamConverter.convertTeamEntityToTeamDto(teamEntity);
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }
}
