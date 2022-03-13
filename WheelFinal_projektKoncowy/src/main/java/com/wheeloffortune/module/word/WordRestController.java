package com.wheeloffortune.module.word;

import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordRestController {

    @Autowired
    private WordService service;

    @GetMapping("/api/words")
    public List<WordDto> getWords(){
        return service.getAll();
    }

    @GetMapping("/api/word/{uuid}")
    public WordDto getWord(@PathVariable String uuid){
        return service.getOne(uuid);
    }

    //@PostMapping("/api/word")
    //public WordDto newWord(@RequestBody @Valid WordForm form){
    //    return service.create(form)
    //}

    //@PutMapping("/api/word/{uuid}")
    //public WordDto updateWord(@PathVariable String uuid, @RequestBody WordForm form){
    //    return service.update(uuid,form)
    //}

    @DeleteMapping("/api/word/{uuid}")
    public void deleteWord(@PathVariable String uuid){
        service.delete(uuid);
    }
}
