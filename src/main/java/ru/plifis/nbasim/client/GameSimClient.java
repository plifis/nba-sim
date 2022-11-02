package ru.plifis.nbasim.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import ru.plifis.nbasim.model.dto.GameDto;
import ru.plifis.nbasim.model.dto.TeamDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameSimClient {
    @Value("{$engine-url}")
    private String url;

    private final RestTemplate restTemplate = new RestTemplate();

    public GameSimClient() {
    }

    @PostMapping("simulate_game")
    public GameDto simulationGame(TeamDto teamHome, TeamDto teamAway) {
        Map<String, TeamDto> teams = new HashMap<>();
        teams.put("home", teamHome);
        teams.put("away", teamAway);
        return restTemplate.postForEntity(
                String.format("%s/", url), teams, GameDto.class).getBody();
    }
}