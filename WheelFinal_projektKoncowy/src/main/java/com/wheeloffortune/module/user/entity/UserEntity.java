package com.wheeloffortune.module.user.entity;

import com.wheeloffortune.module.game.entity.WheelOfFortuneEntity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @ManyToOne
    private WheelOfFortuneEntity wheelOfFortune;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public WheelOfFortuneEntity getWheelOfFortuneEntity() {
        return wheelOfFortune;
    }

    public UserEntity setWheelOfFortuneEntity(WheelOfFortuneEntity wheelOfFortune) {
        this.wheelOfFortune = wheelOfFortune;
        return this;
    }
}
