package com.wheeloffortune.module.user.dto;

import java.util.Set;

public class UserDto {

    private String uuid;
    private String username;
    private Set<String> games;

    public UserDto(String uuid, String username, Set<String> games) {
        this.uuid = uuid;
        this.username = username;
        this.games = games;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getGames() {
        return games;
    }
}
