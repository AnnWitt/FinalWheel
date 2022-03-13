package com.wheeloffortune.module.word.dto;

import java.util.UUID;

public class WordDto {

    private String word;
    private String categoryName;

    public WordDto(String word, String categoryName) {
        this.word = word;
        this.categoryName = categoryName;
    }

    public String getWord() {
        return word;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
