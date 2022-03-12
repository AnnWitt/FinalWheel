package com.wheeloffortune.module.word;

import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordRestController {

    @Autowired
    private WordService service;

    @GetMapping("/api/admin/words")
    public List<WordDto> getWords(){
        return service.all();
    }

}
