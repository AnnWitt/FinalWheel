package com.wheeloffortune.module.word.dto;

import com.wheeloffortune.module.word.entity.WordEntity;
import java.util.Set;

public class CategoryDto {

    private String uuid;
    private String name;
    private Set<WordEntity> words;


    public CategoryDto(String uuid, String name, Set<WordEntity> words) {
        this.uuid = uuid;
        this.name = name;
        this.words = words;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Set<WordEntity> getWords() {
        return words;
    }
}
