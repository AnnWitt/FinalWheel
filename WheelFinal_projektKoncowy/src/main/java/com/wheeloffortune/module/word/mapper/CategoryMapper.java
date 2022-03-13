package com.wheeloffortune.module.word.mapper;

import com.wheeloffortune.module.word.dto.CategoryDto;

import com.wheeloffortune.module.word.dto.WordForm;
import com.wheeloffortune.module.word.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryDto map(CategoryEntity category) {
        return new CategoryDto(
                category.getUuid(),
                category.getName(),
                category.getWords()
        );
    }
}
