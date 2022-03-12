package com.wheeloffortune.core.module.game.user.entity;

import com.wheeloffortune.core.module.game.entity.WheelOfFortuneEntity;

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
}
