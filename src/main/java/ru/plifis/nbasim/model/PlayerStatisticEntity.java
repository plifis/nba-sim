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
@Table(name = "player_statistic")
public class PlayerStatisticEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;

    @OneToMany
    private List<PlayerStatisticSeasonEntity> playerStatisticSeasonEntityList;
}