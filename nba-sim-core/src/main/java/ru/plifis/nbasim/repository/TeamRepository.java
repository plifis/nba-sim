package ru.plifis.nbasim.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plifis.nbasim.model.TeamEntity;

import java.util.Collection;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {

    TeamEntity findTeamEntityById(Integer id);

    Collection<TeamEntity> findAll();
}
