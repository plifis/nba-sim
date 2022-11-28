package ru.plifis.nbasim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import ru.plifis.nbasimmodel.model.enums.PositionEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

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
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private PositionEnum position;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "birthplace")
    private String birthPlace;

    @Column(name = "birth_country")
    private String birthCountry;
    private Integer height; //cm
    private Integer weight; //kg

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skillsets_id")
    @Cascade(CascadeType.ALL)
    private SkillSetEntity skillsets;

    @OneToMany
    @JoinColumn(name = "player_id")
    private List<PlayerStatisticSeasonEntity> playersStatistics;

}