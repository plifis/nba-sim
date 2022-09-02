package ru.plifis.nbasim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.plifis.nbasim.model.dto.TeamDto;
import ru.plifis.nbasim.services.TeamService;

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
        return ResponseEntity.ok(teamService.findTeamById(id));
    }

    @GetMapping("/team/all")
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.finAllTeams());
    }

    //обработка дублей команд
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