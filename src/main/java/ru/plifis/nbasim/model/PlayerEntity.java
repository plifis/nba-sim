package ru.plifis.nbasim.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import ru.plifis.nbasim.model.enums.PositionEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
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
    private Double height;
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractEntity contractEntity;

    @OneToOne
    @JoinColumn(name = "skills_id")
    private SkillEntity skillEntity;

    @ManyToMany
    @JoinColumn(name = "badge_id")
    private List<BadgeEntity> badgeEntityList;
}