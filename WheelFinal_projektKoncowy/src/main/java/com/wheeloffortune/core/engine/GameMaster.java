package com.wheeloffortune.core.engine;

import com.wheeloffortune.core.enums.TurnEnum;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.service.WOTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameMaster {

    @Autowired
    private Random random;

    @Autowired
    private WOTService GameService;

    final String chosenWord = random.generateRNGWord().orElseThrow(() -> new RuntimeException("word has not been chosen")).getWord();
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState = prepareCurrentWordState();
    private final static int pointValue = 10;

    private String prepareCurrentWordState() {
        for(int i = chosenWord.length(); i >= 0 ; i--){
            currentWordState = new StringBuilder(currentWordState).append("_").toString();
        }
        return currentWordState;
    }

    private TurnEnum turn;

    public boolean startGame(String letter, String gameUuid){
        if(Validator.validate(letter)){
            if(Confirm.letterIsLetterInWord(letter,chosenWord)){
                changeScore();
                changeTurn();
                fillOutCurrentWordState(letter);
                updateGameState(gameUuid);
                return true;
            }
            return false;
        }
        return false;
    }

    private void updateGameState(String gameUuid) {
        WOTForm form = createGameForm();
        GameService.update(gameUuid,form);
    }

    private WOTForm createGameForm() {
        return new WOTForm()
                .setPlayerOneScore(playerOneScore)
                .setPlayerTwoScore(playerTwoScore)
                .setCurrentWordState(currentWordState)
                .setTurn(turn);
    }

    private void fillOutCurrentWordState(String letter) {
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < chosenWord.length(); i++){
            if(chosenWord.charAt(i) == letter.charAt(0)){
                indexes.add(i);
            }
        }
        indexes.forEach((index) -> currentWordState = currentWordState.replace(currentWordState.charAt(index), letter.charAt(0)));
    }

    private void changeScore() {
        switch (turn){
            case PLAYER1:
                playerOneScore += pointValue;
                break;
            case PLAYER2:
                playerTwoScore += pointValue;
                break;
        }
    }

    private void changeTurn() {
        switch (turn){
            case PLAYER1:
                turn = TurnEnum.PLAYER2;
                break;
            case PLAYER2:
                turn = TurnEnum.PLAYER1;
                break;
        }
    }
}
