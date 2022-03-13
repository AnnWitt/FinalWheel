package com.wheeloffortune.module.word.mapper;

import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.dto.WordForm;
import com.wheeloffortune.module.word.entity.CategoryEntity;
import com.wheeloffortune.module.word.entity.WordEntity;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class WordMapper {
    public static WordDto map(WordEntity word){
        return new WordDto(
                word.getUuid(),
                word.getWord(),
                CategoryMapper.map(word.getCategory()).getName()
        );
    }

    public static List<WordDto> map(List<WordEntity> words) {
        return words.stream()
                .map(WordMapper::map)
                .collect(Collectors.toList());
    }

    public static WordEntity map(WordForm form, CategoryEntity category) {
        return new WordEntity()
                .setUuid(UUID.randomUUID().toString())
                .setWord(form.getWord())
                .setCategory(category);

    }
}
