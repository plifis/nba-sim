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
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "statistics")
public class StatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pointsTotal;
    private Integer assistsTotal;
    private Integer offReboundsTotal;
    private Integer defReboundsTotal;
    private Integer reboundsTotal;
    private Integer stealsTotal;
    private Integer blocksTotal;
    private Integer gamesPlayedTotal;
    private Integer gamesStartTotal;

    private Double pointsPerGame;
    private Double assistsPerGame;
    private Double reboundPerGame;
    private Double stealsPerGame;
    private Double blocksPerGame;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StatisticEntity that = (StatisticEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
