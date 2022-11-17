package ru.plifis.nbasim.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.plifis.nbasim.services.GameService;
import ru.plifis.nbasim.services.TeamService;
import ru.plifis.nbasimmodel.model.dto.GameDto;
import ru.plifis.nbasimmodel.model.dto.TeamDto;

import javax.websocket.server.PathParam;


@RestController
@EnableKafka
public class GameSimClient {
    @Value("${url-engine}")
    private String urlEngine;
    private final TeamService teamService;
    private final GameService gameService;
    private final RestTemplate restTemplate = new RestTemplate();

    public GameSimClient(TeamService teamService, GameService gameService) {
        this.teamService = teamService;
        this.gameService = gameService;
    }

    @GetMapping("/simulate_game")
    public void simulationGame(@PathParam("idHome") Long idHome,
                               @PathParam ("idAway") Long idAway) {

        GameDto gameDto = new GameDto()
                .setHomeTeam(new TeamDto().setId(idHome))
                .setAwayTeam(new TeamDto().setId(idAway));

        gameDto = gameService.preparationGameForSimulation(gameDto);
        restTemplate.put(
                String.format("%s", urlEngine), gameDto, GameDto.class);
    }

    //заглушка
    @KafkaListener(id = "1", topics = "results", containerFactory = "containerFactory")
    public void getResultGame(ConsumerRecord<Long, GameDto> gameDto) {
        GameDto game = gameDto.value();
        System.out.printf("%s : %s %s %d : %d%n",
                game.getHomeTeam().getName(), game.getAwayTeam().getName(),
                System.lineSeparator(),
                game.getHomeStatistic().getPointsTotal(), game.getAwayStatistic().getPointsTotal());
    }
}