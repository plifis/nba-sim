package ru.plifis.nbasim.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.plifis.nbasim.services.TeamService;
import ru.plifis.nbasimmodel.model.dto.GameDto;
import ru.plifis.nbasimmodel.model.dto.TeamDto;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableKafka
public class GameSimClient {
    @Value("${url-engine}")
    private String urlEngine;
    private final TeamService teamService;

    private final RestTemplate restTemplate = new RestTemplate();

    public GameSimClient(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/simulate_game")
    public void simulationGame(@PathParam("idHome") Long idHome, @PathParam ("idAway") Long idAway) {
        TeamDto home = teamService.findTeamById(idHome);
        TeamDto away = teamService.findTeamById(idAway);
        Map<String, TeamDto> teams = new HashMap<>();
        teams.put("home", home);
        teams.put("away", away);
        restTemplate.put(
                String.format("%s", urlEngine), teams, GameDto.class);
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