package com.wheeloffortune.module.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wheeloffortune.module.game.entity.WheelOfFortuneEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = "wheelOfFortune")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String username;
    @ManyToMany(mappedBy = "players")
    private Set<WheelOfFortuneEntity> wheelOfFortune;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UserEntity setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<WheelOfFortuneEntity> getWheelOfFortune() {
        return wheelOfFortune;
    }

    public UserEntity setWheelOfFortune(Set<WheelOfFortuneEntity> wheelOfFortune) {
        this.wheelOfFortune = wheelOfFortune;
        return this;
    }
}
