package com.wheeloffortune.module.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wheeloffortune.core.enums.TurnEnum;
import com.wheeloffortune.module.user.entity.UserEntity;
import com.wheeloffortune.module.word.entity.WordEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "game")
@JsonIgnoreProperties(value = {"players", "wordEntity"})
public class WOTEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private TurnEnum turn;
    @ManyToMany
    private Set<UserEntity> players;
    @OneToOne
    private WordEntity wordEntity;

    public Long getId() {
        return id;
    }

    public WOTEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public WOTEntity setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    public WOTEntity setPlayerOneScore(Integer playerOneScore) {
        this.playerOneScore = playerOneScore;
        return this;
    }

    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    public WOTEntity setPlayerTwoScore(Integer playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
        return this;
    }

    public String getCurrentWordState() {
        return currentWordState;
    }

    public WOTEntity setCurrentWordState(String currentWordState) {
        this.currentWordState = currentWordState;
        return this;
    }

    public TurnEnum getTurn() {
        return turn;
    }

    public WOTEntity setTurn(TurnEnum turn) {
        this.turn = turn;
        return this;
    }

    public Set<UserEntity> getPlayers() {
        return players;
    }

    public WOTEntity setPlayers(Set<UserEntity> players) {
        this.players = players;
        return this;
    }

    public WordEntity getWordEntity() {
        return wordEntity;
    }

    public WOTEntity setWordEntity(WordEntity wordEntity) {
        this.wordEntity = wordEntity;
        return this;
    }
}
