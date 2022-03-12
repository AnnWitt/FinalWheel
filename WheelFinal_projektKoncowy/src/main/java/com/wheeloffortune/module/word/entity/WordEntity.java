package com.wheeloffortune.module.word.entity;

import com.wheeloffortune.module.game.entity.WheelOfFortuneEntity;

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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public WordEntity setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
        return this;
    }

    public WheelOfFortuneEntity getWheelOfFortuneEntity() {
        return wheelOfFortuneEntity;
    }

    public WordEntity setWheelOfFortuneEntity(WheelOfFortuneEntity wheelOfFortuneEntity) {
        this.wheelOfFortuneEntity = wheelOfFortuneEntity;
        return this;
    }
}
