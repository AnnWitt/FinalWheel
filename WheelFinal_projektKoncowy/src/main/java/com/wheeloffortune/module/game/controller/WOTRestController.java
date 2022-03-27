package com.wheeloffortune.module.game.controller;

import com.wheeloffortune.module.game.dto.WOTDto;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.service.WOTService;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

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
    @GetMapping("/api/game/init/{uuid1},{uuid2}")
    public String init(@PathVariable String uuid1,@PathVariable String uuid2){
        return service.init(Arrays.asList(uuid1, uuid2)).getUuid();
    }
    @GetMapping("/api/game/{uuid}/{letter}")
    public String run(@PathVariable String uuid, @PathVariable String letter){
        return service.run(uuid,letter);
    }

}
