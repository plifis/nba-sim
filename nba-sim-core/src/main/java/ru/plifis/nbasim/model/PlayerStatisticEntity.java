//package ru.plifis.nbasim.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import lombok.experimental.Accessors;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@Accessors(chain = true)
//@Table(name = "player_statistics")
//public class PlayerStatisticEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @OneToMany
//    @ToString.Exclude
//    private List<PlayerStatisticSeasonEntity> playerStatisticSeasonEntityList;
//}