package ru.plifis.nbasim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.plifis.nbasim.converters.PlayerConverter;
import ru.plifis.nbasim.model.PlayerEntity;
import ru.plifis.nbasim.model.dto.PlayerDto;
import ru.plifis.nbasim.repository.PlayersRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayersService {
    private static final Integer PAGE_SIZE = 500;
    private final PlayersRepository playersRepository;
    private final PlayerConverter playerConverter;


    @Autowired
    public PlayersService(PlayersRepository playersRepository, PlayerConverter playerConverter) {
        this.playersRepository = playersRepository;
        this.playerConverter = playerConverter;
    }


    public PlayerDto findPlayerById(Long id) {
        var playerEntity = playersRepository.findPlayerEntityById(id);
        return playerConverter.convertPlayerEntityToPlayerDto(playerEntity);
    }

    //переписать для Pageable, который должен браться и сервиса настроек из БД
    public List<PlayerDto> findAllPlayers() {
        Collection<PlayerEntity> playerEntityList =  playersRepository.findAllPlayers(Pageable.ofSize(PAGE_SIZE));
        return playerEntityList.stream().map(dto -> playerConverter.convertPlayerEntityToPlayerDto(dto)).collect(Collectors.toList());
    }

    public Long createPlayer(PlayerDto player) {
        var playerEntity = playerConverter.convertPlayerDtoToPlayerEntity(player);
        return playersRepository.save(playerEntity).getId();
    }

    public Long updatePlayerById(Long id, PlayerDto player) {
        PlayerEntity playerEntity = playersRepository.findPlayerEntityById(id);
        if (playerEntity == null) {
            throw new IllegalArgumentException(String.format("id %s not found", id));
        }
        playerEntity = playerConverter.updatePlayerEntityFromPlayerDto(player);
        return playersRepository.save(playerEntity).getId();
    }

    public void deletePlayerById(Long id) {
        playersRepository.deleteById(id);
    }
}