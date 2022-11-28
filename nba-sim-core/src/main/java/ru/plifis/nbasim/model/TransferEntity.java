package ru.plifis.nbasim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "transfers")
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "team_source_id")
    private TeamEntity source;

    @OneToOne
    @JoinColumn(name = "team_destination_id")
    private TeamEntity destination;

    @OneToMany
    @JoinTable(name = "transfers_players",
            joinColumns =
            @JoinColumn(name = "transfer_id"),
            inverseJoinColumns =
            @JoinColumn(name = "player_id"))
    private List<PlayerEntity> playerEntitiesTeamSource;

    @OneToMany
    @JoinTable(name = "transfers_players",
            joinColumns =
            @JoinColumn(name = "transfer_id"),
            inverseJoinColumns =
            @JoinColumn(name = "player_id"))
    private List<PlayerEntity> playerEntitiesTeamDestination;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        TransferEntity that = (TransferEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}