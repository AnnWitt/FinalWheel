package com.wheeloffortune.core.module.game.word.entity;

import com.wheeloffortune.core.module.game.entity.WheelOfFortuneEntity;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class WordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    @ManyToOne
    private CategoryEntity categoryEntity;
    @OneToOne
    private WheelOfFortuneEntity wheelOfFortuneEntity;
}
