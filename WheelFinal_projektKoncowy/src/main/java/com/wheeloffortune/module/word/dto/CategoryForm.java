package com.wheeloffortune.module.word.dto;

import com.wheeloffortune.module.word.entity.WordEntity;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class CategoryForm {

    private String uuid;
    @NotNull(message = "category needs to exist")
    private String name;
    private Set<WordEntity> words;

    public CategoryForm() {
    }

    public String getUuid() {
        return uuid;
    }

    public CategoryForm setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryForm setName(String name) {
        this.name = name;
        return this;
    }

    public Set<WordEntity> getWords() {
        return words;
    }

    public CategoryForm setWords(Set<WordEntity> words) {
        this.words = words;
        return this;
    }
}
