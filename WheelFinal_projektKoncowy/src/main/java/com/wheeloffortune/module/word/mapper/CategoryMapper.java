package com.wheeloffortune.module.word.mapper;

import com.wheeloffortune.module.word.dto.CategoryDto;

import com.wheeloffortune.module.word.dto.CategoryForm;
import com.wheeloffortune.module.word.dto.WordForm;
import com.wheeloffortune.module.word.entity.CategoryEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDto map(CategoryEntity category) {
        return new CategoryDto(
                category.getUuid(),
                category.getName(),
                category.getWords()
        );
    }

    public static List<CategoryDto> map(List<CategoryEntity> categories) {
        return categories.stream()
                .map(CategoryMapper::map)
                .collect(Collectors.toList());
    }

    public static CategoryEntity map(CategoryForm form) {
        return new CategoryEntity()
                .setUuid(UUID.randomUUID().toString())
                .setName(form.getName())
                .setWords(form.getWords());
    }
}
