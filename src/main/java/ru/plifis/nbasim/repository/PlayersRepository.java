package ru.plifis.nbasim.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plifis.nbasim.model.PlayerEntity;

import java.util.Collection;

@Repository
public interface PlayersRepository extends CrudRepository<PlayerEntity, Long> {

    PlayerEntity findPlayerEntityById(Long id);

    Collection<PlayerEntity> findAllPlayers(Pageable pageable);
}