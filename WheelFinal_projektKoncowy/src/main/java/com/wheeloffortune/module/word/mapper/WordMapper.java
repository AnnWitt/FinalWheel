package com.wheeloffortune.module.word.mapper;

import com.wheeloffortune.module.word.dto.CategoryDto;
import com.wheeloffortune.module.word.entity.CategoryEntity;

public class WordMapper {

    public static CategoryDto map(CategoryEntity category) {
        return new CategoryDto(
                category.getName(),
                category.getWords()
        );
    }
}
