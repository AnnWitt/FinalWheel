package com.wheeloffortune.module.word.dto;

public class WordDto {

    private String uuid;
    private String word;
    private String categoryName;


    public WordDto(String uuid, String word, String categoryName) {
        this.uuid = uuid;
        this.word = word;
        this.categoryName = categoryName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getWord() {
        return word;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
