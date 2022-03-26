package com.wheeloffortune.core.engine;

import com.wheeloffortune.core.enums.TurnEnum;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.service.WOTService;
import org.springframework.beans.factory.annotation.Autowired;

public class GameMaster {

    @Autowired
    private Random random ;

    @Autowired
    private WOTService GameService;

    private String chosenWord = random.generateRNGWord().getWord();
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private String currentWordState = chosenWord.replaceAll("[A-Za-z0-9]", "_");
    private final static int pointValue = 10;
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
        char[] chars = currentWordState.toCharArray();
        for (int i = 0; i < chosenWord.length(); i++) {
            if(chosenWord.charAt(i) == letter.charAt(0)){
                chars[i] = letter.charAt(0);
            }
        }
        currentWordState = String.valueOf(chars);
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
