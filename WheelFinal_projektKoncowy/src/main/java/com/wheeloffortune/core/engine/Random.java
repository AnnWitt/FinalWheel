package com.wheeloffortune.core.engine;

import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.service.CategoryService;
import com.wheeloffortune.module.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Random {

    @Autowired
    private WordService wordService;

    @Autowired
    private CategoryService categoryService;

    public String generateRNGCategory(){
        return categoryService.getRandomCategory().getUuid();
    }

    public WordDto generateRNGWord(){
        return wordService.findRandomWord();
    }
}
