package ru.plifis.nbasim.services;

import org.springframework.stereotype.Service;
import ru.plifis.nbasim.converters.TeamConverter;
import ru.plifis.nbasim.exceptions.TeamException;
import ru.plifis.nbasim.repository.TeamRepository;
import ru.plifis.nbasim.model.TeamEntity;
import ru.plifis.nbasimmodel.model.dto.TeamDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamConverter teamConverter;
    private final PlayersService playersService;
    private static final String NOT_FOUND_TEAM = "Team with ID %s not found";

    public TeamService(TeamRepository teamRepository, TeamConverter teamConverter, PlayersService playersService) {
        this.teamRepository = teamRepository;
        this.teamConverter = teamConverter;
        this.playersService = playersService;
    }

    public TeamDto findTeamById(Long id) {
        TeamEntity teamEntity = teamRepository.findTeamEntityById(id);

        if (teamEntity == null) {
            throw new TeamException(String.format(NOT_FOUND_TEAM, id));
        }
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
            throw new TeamException(String.format(NOT_FOUND_TEAM, id));
        }
        teamEntity = teamConverter.updateTeamEntityFromTeamDto(teamDto);
        teamEntity =  teamRepository.save(teamEntity);
        return teamConverter.convertTeamEntityToTeamDto(teamEntity);
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }
}