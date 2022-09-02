package ru.plifis.nbasim.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "playoffs")
public class PlayOffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startPlayOff;
    private LocalDate endPlayOff;
    private String namePlayOff;

    @OneToMany(mappedBy = "teams")
    private List<TeamEntity> teams;

    @OneToMany(mappedBy = "rounds")
    private List<RoundPOEntity> roundPOEntityList;
}