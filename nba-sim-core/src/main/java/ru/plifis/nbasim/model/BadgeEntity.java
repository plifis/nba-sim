package ru.plifis.nbasim.model;

import ru.plifis.nbasimmodel.model.enums.BadgeEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//заготовка под класс с Бэйджами
public class BadgeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "badge_name")
    private BadgeEnum badgeName;
}