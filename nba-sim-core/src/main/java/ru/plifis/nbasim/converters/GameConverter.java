package ru.plifis.nbasim.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.plifis.nbasim.model.GameEntity;
import ru.plifis.nbasimmodel.model.dto.GameDto;

@Service
public class GameConverter {
    private final ModelMapper modelMapper;

    public GameConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GameEntity convertGameDtoToGameEntity(GameDto gameDto) {
        return modelMapper.map(gameDto, GameEntity.class);
    }

    public GameDto convertGameEntityToGameDto(GameEntity gameEntity) {
        return modelMapper.map(gameEntity, GameDto.class);
    }

    public GameEntity updateGameEntityFromGameDto(GameDto gameDto) {
        GameEntity updateGame = new GameEntity();
        modelMapper.map(gameDto, updateGame);
        return updateGame;
    }
}
