package com.wheeloffortune.module.game.mapper;

import com.wheeloffortune.module.game.dto.WOTDto;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.entity.WOTEntity;
import com.wheeloffortune.module.user.entity.UserEntity;
import com.wheeloffortune.module.user.mapper.UserMapper;
import com.wheeloffortune.module.word.entity.WordEntity;
import com.wheeloffortune.module.word.mapper.WordMapper;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class WOTMapper {

    public static Set<String> map(Set<WOTEntity> games){
        return games.stream().map(WOTEntity::getUuid).collect(Collectors.toSet());
    }

    public static WOTDto map(WOTEntity game){
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

    public static List<WOTDto> map(List<WOTEntity> games) {
        return games.stream()
                .map(WOTMapper::map)
                .collect(Collectors.toList());
    }

    public static WOTEntity map(WOTForm form, Set<UserEntity> users, WordEntity word){
        return new WOTEntity()
                .setUuid(UUID.randomUUID().toString())
                .setPlayerOneScore(form.getPlayerOneScore())
                .setPlayerTwoScore(form.getPlayerTwoScore())
                .setCurrentWordState(form.getCurrentWordState())
                .setTurn(form.getTurn())
                .setPlayers(users)
                .setWordEntity(word);
    }
}
