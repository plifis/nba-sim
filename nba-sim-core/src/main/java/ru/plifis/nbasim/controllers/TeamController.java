package ru.plifis.nbasim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.plifis.nbasim.services.TeamService;
import ru.plifis.nbasimmodel.model.dto.TeamDto;

import java.util.List;

@RestController
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable("id") Long id) {
        TeamDto teamDto = teamService.findTeamById(id);
        return ResponseEntity.ok().body(teamDto);
    }

    @GetMapping("/team/all")
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.finAllTeams());
    }

    //обработка дублей команд - добавить
    @PostMapping("/team/add")
    public ResponseEntity<Long> createTeam(@RequestBody TeamDto teamDto) {
        Long id = teamService.createTeam(teamDto);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/team/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable("id") Long id,
                                              @RequestBody TeamDto teamDto) {
        TeamDto rsl = teamService.updateTeam(id, teamDto);
        return ResponseEntity.ok().body(rsl);
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeamById(id);
        return ResponseEntity.ok().build();
    }
}