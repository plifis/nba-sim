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
import ru.plifis.nbasim.services.PlayersService;
import ru.plifis.nbasimmodel.model.dto.PlayerDto;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayersController {
    private final PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable("id") Long id) {
        PlayerDto resp = Optional.ofNullable(playersService.findPlayerById(id)).orElse(null);
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping({"/player/all", "/players", "/player"})
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        List<PlayerDto> resp = Optional.ofNullable(playersService.findAllPlayers()).orElse(null);
        return ResponseEntity.ok().body(resp);
    }

    @PostMapping("/player/add")
    public ResponseEntity<Long> createPlayer(@RequestBody PlayerDto player) {
        Long resp = Optional.ofNullable(playersService.createPlayer(player)).orElse(null);
        return ResponseEntity.ok().body(resp);
    }

    @PutMapping("/player/update/{id}")
    public ResponseEntity<Long> updatePlayerById(@PathVariable("id") Long id,
                                                 @RequestBody PlayerDto player) {
        id = playersService.updatePlayerById(id, player);
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/player/delete/{id}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable("id") Long id) {
        playersService.deletePlayerById(id);
        return ResponseEntity.ok().build();
    }
}