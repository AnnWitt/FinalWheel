package com.wheeloffortune.module.user.mapper;

import com.wheeloffortune.module.game.entity.WheelOfFortuneEntity;
import com.wheeloffortune.module.user.dto.UserDto;
import com.wheeloffortune.module.user.dto.UserForm;
import com.wheeloffortune.module.user.entity.UserEntity;
import com.wheeloffortune.module.word.dto.WordDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto map(UserEntity user){
        return new UserDto(
                user.getUuid(),
                user.getUsername(),
                user.getWheelOfFortune().stream().map(WheelOfFortuneEntity::getUuid).collect(Collectors.toSet())
        );
    }

    public static List<UserDto> map(List<UserEntity> users) {
        return users.stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

    public static UserEntity map(UserForm form){
        return new UserEntity()
                .setUuid(UUID.randomUUID().toString())
                .setUsername(form.getUsername())
                .setWheelOfFortune(form.getGames());
    }
}
