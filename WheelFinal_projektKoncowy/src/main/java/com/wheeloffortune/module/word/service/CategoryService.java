package com.wheeloffortune.module.word.service;

import com.wheeloffortune.module.word.dto.CategoryDto;
import com.wheeloffortune.module.word.dto.CategoryForm;
import com.wheeloffortune.module.word.entity.CategoryEntity;
import com.wheeloffortune.module.word.mapper.CategoryMapper;
import com.wheeloffortune.module.word.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<CategoryDto> getAll() {
        return CategoryMapper.map(
                repository.findAll()
        );
    }

    public CategoryDto getOne(String uuid) {
        return CategoryMapper.map(
                repository.findOneByUuid(uuid)
        );
    }

    public CategoryDto create(CategoryForm form) {


        CategoryEntity category = CategoryMapper.map(form);
        return CategoryMapper.map(
                repository.saveAndFlush(category)
        );
    }

    public CategoryDto update(String uuid, CategoryForm form) {

        CategoryEntity fromDB = repository.findOneByUuid(uuid)
                .setName(form.getName());
        if (!form.getWords().isEmpty()) {
            form.setWords(form.getWords());
        }
        return CategoryMapper.map(
                repository.saveAndFlush(fromDB)
        );
    }

    public void delete(String uuid) {
        repository.delete(
                repository.findOneByUuid(uuid)
        );
    }
}
