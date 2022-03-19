package com.wheeloffortune.module.user.dto;

import com.wheeloffortune.module.game.entity.WheelOfFortuneEntity;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public class UserForm {

    private String uuid;
    @NotNull(message = "user requires a name")
    private String username;
    private Set<WheelOfFortuneEntity> games;

    public UserForm() {}

    public String getUuid() {
        return uuid;
    }

    public UserForm setUuid(String uuid) {
        this.uuid = UUID.randomUUID().toString();
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<WheelOfFortuneEntity> getGames() {
        return games;
    }

    public UserForm setGames(Set<WheelOfFortuneEntity> games) {
        this.games = games;
        return this;
    }
}
