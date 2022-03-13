package com.wheeloffortune.module.word.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wheeloffortune.module.game.entity.WheelOfFortuneEntity;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "word")
@JsonIgnoreProperties("category")
public class WordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @OneToOne
    private WheelOfFortuneEntity wheelOfFortune;


    public Long getId() {
        return id;
    }

    public WordEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getWord() {
        return word;
    }

    public WordEntity setWord(String word) {
        this.word = word;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public WordEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public WheelOfFortuneEntity getWheelOfFortune() {
        return wheelOfFortune;
    }

    public WordEntity setWheelOfFortune(WheelOfFortuneEntity wheelOfFortune) {
        this.wheelOfFortune = wheelOfFortune;
        return this;
    }
}
