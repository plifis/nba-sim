package ru.plifis.nbasim.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.plifis.nbasim.model.PlayerEntity;
import ru.plifis.nbasim.model.dto.PlayerDto;

@Service
public class PlayerConverter {
    private ModelMapper modelMapper;

    public PlayerConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerEntity updatePlayerEntityFromPlayerDto(PlayerDto playerDto) {
        PlayerEntity updatePlayer = new PlayerEntity();
        modelMapper.map(playerDto, updatePlayer);
        return updatePlayer;
    }

    public PlayerDto convertPlayerEntityToPlayerDto(PlayerEntity playerEntity) {
        return modelMapper.map(playerEntity, PlayerDto.class);
    }

    public PlayerEntity convertPlayerDtoToPlayerEntity(PlayerDto playerDto) {
        return modelMapper.map(playerDto, PlayerEntity.class);
    }
}