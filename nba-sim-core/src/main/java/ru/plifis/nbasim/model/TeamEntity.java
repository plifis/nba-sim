package ru.plifis.nbasim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import ru.plifis.nbasimmodel.model.enums.MarketEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "teams")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String arena;

    @Column(name = "market_size")
    @Enumerated(EnumType.STRING)
    private MarketEnum marketSize;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    @ToString.Exclude
    private Set<PlayerEntity> playersList = new HashSet<>();

    private BigDecimal salaryCap;
    private BigDecimal salaryCurrent;

    @ManyToOne
    @JoinColumn(name = "playoff_id", nullable = true)
    private PlayOffEntity playOff;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        TeamEntity that = (TeamEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}