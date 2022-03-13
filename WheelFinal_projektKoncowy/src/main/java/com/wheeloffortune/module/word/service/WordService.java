package com.wheeloffortune.module.word.service;


import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.mapper.WordMapper;
import com.wheeloffortune.module.word.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository repository;

    public List<WordDto> getAll(){
        return WordMapper.map(
                repository.findAll()
        );
    }

    public WordDto getOne(Long id ){
        return repository.findById(id)
                .map(WordMapper::map)
                .get();
    }

    //public WordDto create{}

    public void delete(Long id) {
        repository.delete(
                repository.getById(id)
        );
    }
}
