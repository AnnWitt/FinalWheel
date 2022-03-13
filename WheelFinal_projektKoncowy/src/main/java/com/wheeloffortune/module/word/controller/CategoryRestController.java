package com.wheeloffortune.module.word.controller;

import com.wheeloffortune.module.word.dto.CategoryDto;
import com.wheeloffortune.module.word.dto.CategoryForm;
import com.wheeloffortune.module.word.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryRestController {
    @Autowired
    private CategoryService service;

    @GetMapping("/api/categories")
    public List<CategoryDto> getWords(){
        return service.getAll();
    }

    @GetMapping("/api/category/{uuid}")
    public CategoryDto getWord(@PathVariable String uuid){
        return service.getOne(uuid);
    }

    @PostMapping("/api/category")
    public CategoryDto newWord(@RequestBody @Valid CategoryForm form){
        return service.create(form);
    }

    @PutMapping("/api/category/{uuid}")
    public CategoryDto updateWord(@PathVariable String uuid, @RequestBody CategoryForm form){
        return service.update(uuid,form);
    }

    @DeleteMapping("/api/category/{uuid}")
    public void deleteWord(@PathVariable String uuid){
        service.delete(uuid);
    }
}
