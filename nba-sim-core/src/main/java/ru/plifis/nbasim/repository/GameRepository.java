package ru.plifis.nbasim.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plifis.nbasim.model.GameEntity;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, Integer> {
}
