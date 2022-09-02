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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "standings")
public class PositionTeamInSeasonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    private Integer win;
    private Integer loss;
}
