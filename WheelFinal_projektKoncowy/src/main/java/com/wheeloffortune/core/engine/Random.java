package com.wheeloffortune.core.engine;

import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.service.CategoryService;
import com.wheeloffortune.module.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Optional<WordDto> generateRNGWord(String categoryUuid){
        return wordService.getAll().stream().filter(word -> categoryService.getOne(categoryUuid).getName().equals(word.getCategoryName())).findAny();
    }
}
