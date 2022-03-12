package com.wheeloffortune.module.word.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany (mappedBy = "category")
    private List<WordEntity> wordlist;

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

    public List<WordEntity> getWordlist() {
        return wordlist;
    }

    public CategoryEntity setWordlist(List<WordEntity> wordlist) {
        this.wordlist = wordlist;
        return this;
    }
}
