package ru.plifis.nbasim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import ru.plifis.nbasim.model.enums.PositionEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Column
    @Enumerated(EnumType.STRING)
    private PositionEnum position;

    private LocalDate birthDate;
    private String birthPlace;
    private String birthCountry;
    private Integer height; //cm
    private Double weight; //kg

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    @OneToOne
    @JoinColumn(name = "skills_id")
    private SkillEntity skill;

    @ManyToMany
    @JoinTable(name = "player_badge",
            joinColumns = @JoinColumn(name = "player_id"),
    inverseJoinColumns = @JoinColumn(name = "badge_id"))
    @ToString.Exclude
    private List<BadgeEntity> badgeEntityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlayerEntity that = (PlayerEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}