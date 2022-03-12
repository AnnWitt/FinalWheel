package com.wheeloffortune.module.word.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String name;
    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
    private List<WordEntity> wordlist;

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
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

    public List<WordEntity> getWordlist() {
        return wordlist;
    }

    public CategoryEntity setWordlist(List<WordEntity> wordlist) {
        this.wordlist = wordlist;
        return this;
    }
}
