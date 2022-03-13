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

    public WordDto getOne(String uuid){
        return WordMapper.map(
                repository.findOneByUuid(uuid)
        );
    }

    //public WordDto create{}

    public void delete(String uuid) {
        repository.delete(
                repository.findOneByUuid(uuid)
        );
    }
}
