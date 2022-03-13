package com.wheeloffortune.module.word.mapper;

import com.wheeloffortune.module.word.dto.WordDto;

public class CategoryMapper {
    public static WordDto map(com.wheeloffortune.module.word.entity.WordEntity word){
        return new WordDto(
                word.getWord(),
                WordMapper.map(word.getCategory())
        );
    }
}
