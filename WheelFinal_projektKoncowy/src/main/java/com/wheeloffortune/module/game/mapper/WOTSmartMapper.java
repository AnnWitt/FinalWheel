package com.wheeloffortune.module.game.mapper;

import com.wheeloffortune.module.game.dto.WOTDto;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.entity.WOTEntity;
import com.wheeloffortune.module.user.mapper.UserMapper;
import com.wheeloffortune.module.user.reposytory.UserRepository;
import com.wheeloffortune.module.word.mapper.WordMapper;
import com.wheeloffortune.module.word.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WOTSmartMapper {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserRepository userRepository;

    public WOTDto map(WOTEntity game){
        return new WOTDto(
                game.getUuid(),
                game.getPlayerOneScore(),
                game.getPlayerTwoScore(),
                game.getCurrentWordState(),
                game.getTurn(),
                UserMapper.mapToString(game.getPlayers()),
                WordMapper.mapToString(game.getWordEntity())
        );
    }

    public WOTEntity map(WOTForm form){
        return new WOTEntity()
                .setUuid(UUID.randomUUID().toString())
                .setPlayerOneScore(form.getPlayerOneScore())
                .setPlayerTwoScore(form.getPlayerTwoScore())
                .setCurrentWordState(form.getCurrentWordState())
                .setTurn(form.getTurn())
                .setPlayers(form.getPlayersUuid().stream()
                                .map(uuid -> userRepository.findOneByUuid(uuid))
                                .collect(Collectors.toSet()))
                .setWordEntity(wordRepository.findOneByUuid(form.getWordUuid()));
    }


    public List<WOTDto> map(List<WOTEntity> games) {
        return games.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
