package com.wheeloffortune.module.word.entity;

import com.wheeloffortune.module.game.entity.WheelOfFortuneEntity;

import javax.persistence.*;


@Entity
@Table(name = "word")
public class WordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String word;
    @ManyToOne
    @JoinColumn(name="wordlist")
    private CategoryEntity category;
    @OneToOne
    private WheelOfFortuneEntity wheelOfFortune;

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
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
