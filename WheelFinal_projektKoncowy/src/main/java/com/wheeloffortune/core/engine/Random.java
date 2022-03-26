package com.wheeloffortune.core.engine;

import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.service.CategoryService;
import com.wheeloffortune.module.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class Random {

    @Autowired
    private WordService wordService;

    @Autowired
    private CategoryService categoryService;

    public String generateRNGCategory(){
        return categoryService.getAll().stream().findAny().get().getUuid();
    }

    public WordDto generateRNGWord(){
        String categoryUuid = generateRNGCategory();
        return wordService.getAll().stream().filter((word) -> Objects.equals(word.getCategoryName(), categoryService.getOne(categoryUuid).getName())).findAny().get();
    }
}
