package com.wheeloffortune.module.word.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wheeloffortune.module.game.entity.WOTEntity;

import javax.persistence.*;


@Entity
@Table(name = "word")
@JsonIgnoreProperties("category")
public class WordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String word;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @OneToOne
    @JoinColumn(name = "wordEntity")
    private WOTEntity wheelOfFortune;

    public String getUuid() {
        return uuid;
    }

    public WordEntity setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

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

    public WOTEntity getWheelOfFortune() {
        return wheelOfFortune;
    }

    public WordEntity setWheelOfFortune(WOTEntity wheelOfFortune) {
        this.wheelOfFortune = wheelOfFortune;
        return this;
    }
}
