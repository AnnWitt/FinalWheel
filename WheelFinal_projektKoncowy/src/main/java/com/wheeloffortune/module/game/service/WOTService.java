package com.wheeloffortune.module.game.service;

import com.wheeloffortune.module.game.dto.WOTDto;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.entity.WOTEntity;
import com.wheeloffortune.module.game.mapper.WOTSmartMapper;
import com.wheeloffortune.module.game.repository.WOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WOTService {

    @Autowired
    private WOTRepository repository;

    @Autowired
    private WOTSmartMapper mapper;

    public WOTDto getOne(String uuid){
        return mapper.map(
                repository.findOneByUuid(uuid)
        );
    }

    public List<WOTDto> getAll(){
        return mapper.map(
                repository.findAll()
        );
    }

    public WOTDto create(WOTForm form){
        WOTEntity game = mapper.map(form);
        return mapper.map(
                repository.saveAndFlush(game)
        );
    }

    public WOTDto update(String uuid, WOTForm form){
        WOTEntity fromDB = repository.findOneByUuid(uuid);
        WOTEntity fromForm = mapper.map(form);
        fromDB.setPlayerOneScore(fromForm.getPlayerOneScore())
                .setPlayerTwoScore(fromForm.getPlayerTwoScore())
                .setCurrentWordState(fromForm.getCurrentWordState())
                .setTurn(fromForm.getTurn());
        if(!fromForm.getPlayers().isEmpty()) {
            fromDB.setPlayers(fromForm.getPlayers());
        }
        if(!fromForm.getPlayers().isEmpty()) {
            fromDB.setWordEntity(fromForm.getWordEntity());
        }
        return  mapper.map(
                repository.saveAndFlush(fromDB)
        );
    }

    public void delete(String uuid){
        repository.delete(
                repository.findOneByUuid(uuid)
        );
    }
}
