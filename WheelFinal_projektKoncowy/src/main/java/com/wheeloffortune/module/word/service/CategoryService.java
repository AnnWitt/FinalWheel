package com.wheeloffortune.module.word.service;

import com.wheeloffortune.module.word.dto.CategoryDto;
import com.wheeloffortune.module.word.mapper.CategoryMapper;
import com.wheeloffortune.module.word.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public CategoryDto getOne(String uuid) {
        return CategoryMapper.map(
                repository.findOneByUuid(uuid)
        );
    }
}
