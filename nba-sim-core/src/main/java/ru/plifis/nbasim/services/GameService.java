package ru.plifis.nbasim.services;

import org.springframework.stereotype.Service;
import ru.plifis.nbasim.converters.GameConverter;
import ru.plifis.nbasim.model.GameEntity;
import ru.plifis.nbasim.repository.GameRepository;
import ru.plifis.nbasimmodel.model.dto.GameDto;
import ru.plifis.nbasimmodel.model.dto.PlayerDto;
import ru.plifis.nbasimmodel.model.dto.TeamDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameConverter gameConverter;
    private final TeamService teamService;

    public GameService(GameRepository gameRepository, GameConverter gameConverter, TeamService teamService) {
        this.gameRepository = gameRepository;
        this.gameConverter = gameConverter;
        this.teamService = teamService;
    }

    public Integer createTeam(GameDto gameDto) {
        GameEntity gameEntity = gameConverter.convertGameDtoToGameEntity(gameDto);
        return gameRepository.save(gameEntity).getId();
    }

    public GameDto preparationGameForSimulation(GameDto gameDto) {
        TeamDto home = teamService.findTeamById(gameDto.getHomeTeam().getId());
        TeamDto away = teamService.findTeamById(gameDto.getAwayTeam().getId());

        gameDto.setHomeTeam(home)
                .setAwayTeam(away);

        if ((gameDto.getStartLineupHomeTeamIds() == null) && (gameDto.getStartLineupAwayTeamIds() == null)) {
            List<Integer> homeStart = teamService.autoStartLineUp(gameDto.getHomeTeam());
            List<Integer> awayStart = teamService.autoStartLineUp(gameDto.getAwayTeam());

            gameDto.setStartLineupHomeTeamIds(homeStart);
            gameDto.setStartLineupAwayTeamIds(awayStart);

            List<Integer> benchHome = gameDto.getHomeTeam().getPlayersList().stream()
                    .map(PlayerDto::getId)
                    .filter(id -> !homeStart.contains(id))
                    .collect(Collectors.toList());


            List<Integer> benchAway = gameDto.getAwayTeam().getPlayersList().stream()
                    .map(PlayerDto::getId)
                    .filter(id -> !awayStart.contains(id))
                    .collect(Collectors.toList());

            gameDto.setBenchHomeTeamIds(benchHome);
            gameDto.setBenchAwayTeamIds(benchAway);
        }

        return gameDto;
    }
}
