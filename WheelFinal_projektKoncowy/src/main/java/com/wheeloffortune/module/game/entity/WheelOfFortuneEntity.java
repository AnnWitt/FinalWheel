package com.wheeloffortune.module.game.entity;

import com.wheeloffortune.core.enums.TurnEnum;
import com.wheeloffortune.module.user.entity.UserEntity;
import com.wheeloffortune.module.word.entity.WordEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class WheelOfFortuneEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState;
    private TurnEnum turn;
    @OneToMany(mappedBy = "wheelOfFortune")
    private List<UserEntity> players;
    @OneToOne(mappedBy = "wheelOfFortune")
    private WordEntity wordEntity;

    public Long getId() {
        return id;
    }

    public WheelOfFortuneEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    public WheelOfFortuneEntity setPlayerOneScore(Integer playerOneScore) {
        this.playerOneScore = playerOneScore;
        return this;
    }

    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    public WheelOfFortuneEntity setPlayerTwoScore(Integer playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
        return this;
    }

    public String getCurrentWordState() {
        return currentWordState;
    }

    public WheelOfFortuneEntity setCurrentWordState(String currentWordState) {
        this.currentWordState = currentWordState;
        return this;
    }

    public TurnEnum getTurn() {
        return turn;
    }

    public WheelOfFortuneEntity setTurn(TurnEnum turn) {
        this.turn = turn;
        return this;
    }

    public List<UserEntity> getPlayers() {
        return players;
    }

    public WheelOfFortuneEntity setPlayers(List<UserEntity> players) {
        this.players = players;
        return this;
    }

    public WordEntity getWordEntity() {
        return wordEntity;
    }

    public WheelOfFortuneEntity setWordEntity(WordEntity wordEntity) {
        this.wordEntity = wordEntity;
        return this;
    }
}
