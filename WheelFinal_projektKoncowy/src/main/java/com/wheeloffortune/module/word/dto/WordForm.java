package com.wheeloffortune.module.word.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class WordForm {

    private String uuid;
    @NotNull(message = "word needs to exist")
    private String word;
    @JsonProperty("category_uuid")
    private String categoryUuid;

    public WordForm() {
    }

    public String getUuid() {
        return uuid;
    }

    public WordForm setUuid(String uuid) {
        this.uuid = UUID.randomUUID().toString();
        return this;
    }

    public String getWord() {
        return word;
    }

    public WordForm setWord(String word) {
        this.word = word;
        return this;
    }

    public String getCategoryUuid() {
        return categoryUuid;
    }

    public WordForm setCategoryUuid(String category_uuid) {
        this.categoryUuid = category_uuid;
        return this;
    }
}
