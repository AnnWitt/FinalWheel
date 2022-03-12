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

    public List<WordDto> all(){
        return WordMapper.map(
                repository.findAll()
        );
    }

    public WordDto one(String uuid){
        return all().stream()
                .filter(word -> word.getUuid().equals(uuid))
                .findFirst()
                .get();
    }

    //public WordDto create(){}

    public void delete(String uuid){
        repository.delete(
                repository.findAll()
                        .stream()
                        .filter(word -> word.getUuid().equals(uuid))
                        .findFirst()
                        .get()
        );
    }
}
