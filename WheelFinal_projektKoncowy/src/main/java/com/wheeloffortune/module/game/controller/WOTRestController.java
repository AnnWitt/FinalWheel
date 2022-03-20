package com.wheeloffortune.module.game.controller;

import com.wheeloffortune.module.game.dto.WOTDto;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.service.WOTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WOTRestController {
    @Autowired
    private WOTService service;

    @GetMapping("/api/games")
    public List<WOTDto> getAll(){
        return service.getAll();
    }
    @GetMapping("/api/game/{uuid}")
    public WOTDto getOne(@PathVariable String uuid){
        return service.getOne(uuid);
    }
    @PostMapping("/api/game")
    public WOTDto create(@RequestBody @Valid WOTForm form){
        return service.create(form);
    }
    @PutMapping("/api/game/{uuid}")
    public WOTDto update(@RequestBody @Valid WOTForm form, @PathVariable String uuid){
        return service.update(uuid,form);
    }
    @DeleteMapping("/api/game/{uuid}")
    public void delete(@PathVariable String uuid){
        service.delete(uuid);
    }
}
