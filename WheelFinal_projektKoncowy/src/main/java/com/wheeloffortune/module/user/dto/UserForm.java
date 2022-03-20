package com.wheeloffortune.module.user.dto;

import com.wheeloffortune.module.game.entity.WOTEntity;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public class UserForm {

    private String uuid;
    @NotNull(message = "user requires a name")
    private String username;
    private Set<WOTEntity> games;

    public UserForm() {}

    public String getUuid() {
        return uuid;
    }

    public UserForm setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<WOTEntity> getGames() {
        return games;
    }

    public UserForm setGames(Set<WOTEntity> games) {
        this.games = games;
        return this;
    }
}
