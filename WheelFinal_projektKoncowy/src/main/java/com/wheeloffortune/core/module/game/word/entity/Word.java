package com.wheeloffortune.core.module.game.word.entity;

import com.wheeloffortune.core.module.game.entity.WheelOfFortune;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    @ManyToOne
    private Category category;
    @OneToOne
    private WheelOfFortune wheelOfFortune;
}
