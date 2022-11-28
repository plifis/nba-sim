package ru.plifis.nbasim.services;

import org.springframework.stereotype.Service;
import ru.plifis.nbasim.converters.TeamConverter;
import ru.plifis.nbasim.exceptions.TeamException;
import ru.plifis.nbasim.model.TeamEntity;
import ru.plifis.nbasim.repository.TeamRepository;
import ru.plifis.nbasimmodel.model.dto.PlayerDto;
import ru.plifis.nbasimmodel.model.dto.TeamDto;
import ru.plifis.nbasimmodel.model.enums.PositionEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public TeamDto findTeamById(Integer id) {
        TeamEntity teamEntity = teamRepository.findTeamEntityById(id);

        if (teamEntity == null) {
            throw new TeamException(String.format(NOT_FOUND_TEAM, id));
        }
        return teamConverter.convertTeamEntityToTeamDto(teamEntity);
    }

    public Integer createTeam(TeamDto teamDto) {
        var teamEntity = teamConverter.convertTeamDtoToTeamEntity(teamDto);
        return teamRepository.save(teamEntity).getId();
    }

    public List<TeamDto> finAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamConverter::convertTeamEntityToTeamDto).collect(Collectors.toList());
    }

    public TeamDto updateTeam(Integer id, TeamDto teamDto) {
        TeamEntity teamEntity = teamRepository.findTeamEntityById(id);
        if (teamEntity == null) {
            throw new TeamException(String.format(NOT_FOUND_TEAM, id));
        }
        teamEntity = teamConverter.updateTeamEntityFromTeamDto(teamDto);
        teamEntity = teamRepository.save(teamEntity);
        return teamConverter.convertTeamEntityToTeamDto(teamEntity);
    }

    public void deleteTeamById(Integer id) {
        teamRepository.deleteById(id);
    }

    public List<Integer> autoStartLineUp(TeamDto teamDto) {
        Map<String, Integer> map = new HashMap<>();
        for (PositionEnum position : PositionEnum.values()) {
            map.put(position.getValue(),
                    teamDto.getPlayersList().stream()
                    .filter(p -> p.getPosition().equals(position))
                    .max(Comparator.comparingInt(x -> x.getSkillsets().getTotalRating()))
                            .map(PlayerDto::getId).orElse(0));
        }
        return new ArrayList<>(map.values());
    }


}