package com.wheeloffortune.module.word.mapper;

import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.entity.WordEntity;

import java.util.List;
import java.util.stream.Collectors;

public class WordMapper {

    public static WordDto map(WordEntity word){
        return new WordDto(
                word.getUuid(),
                word.getWord(),
                CategoryMapper.map(word.getCategory())
        );
    }

    public static List<WordDto> map(List<WordEntity> words){
        return words.stream()
                .map(WordMapper::map)
                .collect(Collectors.toList());
    }

}
