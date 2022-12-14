package ru.plifis.nbasim.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plifis.nbasim.model.PlayerEntity;

import java.util.List;

@Repository
public interface PlayersRepository extends CrudRepository<PlayerEntity, Integer> {

    PlayerEntity findPlayerEntityById(Integer id);

    List<PlayerEntity> findAll(Pageable pageable);
}