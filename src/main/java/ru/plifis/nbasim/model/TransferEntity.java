package ru.plifis.nbasim.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "transfers")
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "team_source_id")
    private TeamEntity source;

    @OneToOne
    @JoinColumn(name = "team_destination_id")
    private TeamEntity destination;

    @OneToMany(mappedBy = "players_team_source")
    private List<PlayerEntity> playerEntitiesTeamSource;

    @OneToMany(mappedBy = "players_team_destination")
    private List<PlayerEntity> playerEntitiesTeamDestination;
}