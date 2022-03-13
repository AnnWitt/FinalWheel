package com.wheeloffortune.module.word.service;


import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.dto.WordForm;
import com.wheeloffortune.module.word.entity.CategoryEntity;
import com.wheeloffortune.module.word.entity.WordEntity;
import com.wheeloffortune.module.word.mapper.CategoryMapper;
import com.wheeloffortune.module.word.mapper.WordMapper;
import com.wheeloffortune.module.word.repository.CategoryRepository;
import com.wheeloffortune.module.word.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<WordDto> getAll(){
        return WordMapper.map(
                repository.findAll()
        );
    }

    public WordDto getOne(String uuid){
        return WordMapper.map(
                repository.findOneByUuid(uuid)
        );
    }

    public WordDto create(WordForm form){

        CategoryEntity category = categoryRepository.findOneByUuid(form.getCategoryUuid());
        WordEntity word = WordMapper.map(form, category);

        return WordMapper.map(
                repository.saveAndFlush(word)
        );
    }

    //public WordDto update{}

    public void delete(String uuid) {
        repository.delete(
                repository.findOneByUuid(uuid)
        );
    }
}
