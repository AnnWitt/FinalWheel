package com.wheeloffortune.module.word.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String name;
    @OneToMany (mappedBy = "category")
    private Set<WordEntity> words;

    public CategoryEntity setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public Long getId() {
        return id;
    }

    public CategoryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Set<WordEntity> getWords() {
        return words;
    }

    public CategoryEntity setWords(Set<WordEntity> words) {
        this.words = words;
        return this;
    }
}
