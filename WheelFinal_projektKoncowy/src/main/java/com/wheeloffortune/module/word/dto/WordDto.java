package com.wheeloffortune.module.word.dto;

import java.util.UUID;

public class WordDto {

    private String uuid;
    private String word;
    private CategoryDto category;

    public WordDto(String uuid, String word, CategoryDto category) {
        this.uuid = UUID.randomUUID().toString();
        this.word = word;
        this.category = category;
    }

    public String getUuid() {
        return uuid;
    }

    public String getWord() {
        return word;
    }

    public CategoryDto getCategory() {
        return category;
    }
}
