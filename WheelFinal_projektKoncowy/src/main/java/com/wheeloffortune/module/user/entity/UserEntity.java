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
    private WheelOfFortuneEntity wheelOfFortuneEntity;

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
        return wheelOfFortuneEntity;
    }

    public UserEntity setWheelOfFortuneEntity(WheelOfFortuneEntity wheelOfFortuneEntity) {
        this.wheelOfFortuneEntity = wheelOfFortuneEntity;
        return this;
    }
}
