package com.wheeloffortune.module.word.dto;

import com.wheeloffortune.module.word.entity.WordEntity;

import java.util.List;
import java.util.UUID;

public class CategoryDto {

    private String uuid;
    private String name;
    private List<WordEntity> wordList;

    public CategoryDto(String uuid, String name, List<WordEntity> wordList) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.wordList = wordList;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<WordEntity> getWordList() {
        return wordList;
    }
}
