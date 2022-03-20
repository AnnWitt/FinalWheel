package com.wheeloffortune.module.user.mapper;

import com.wheeloffortune.module.game.mapper.WOTMapper;
import com.wheeloffortune.module.user.dto.UserDto;
import com.wheeloffortune.module.user.dto.UserForm;
import com.wheeloffortune.module.user.entity.UserEntity;
import com.wheeloffortune.module.user.reposytory.UserRepository;
import com.wheeloffortune.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserDto map(UserEntity user){
        return new UserDto(
                user.getUuid(),
                user.getUsername(),
                WOTMapper.map(user.getWheelOfFortune())
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

    public static Set<String> mapToString(Set<UserEntity> players) {
        return players.stream()
                .map(UserEntity::getUuid)
                .collect(Collectors.toSet());
    }
}
