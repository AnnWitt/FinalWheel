package com.wheeloffortune.module.game.service;

import com.wheeloffortune.core.engine.Confirm;
import com.wheeloffortune.core.engine.Random;
import com.wheeloffortune.core.engine.Validator;
import com.wheeloffortune.core.enums.TurnEnum;
import com.wheeloffortune.module.game.dto.WOTDto;
import com.wheeloffortune.module.game.dto.WOTForm;
import com.wheeloffortune.module.game.entity.WOTEntity;
import com.wheeloffortune.module.game.mapper.WOTSmartMapper;
import com.wheeloffortune.module.game.repository.WOTRepository;
import com.wheeloffortune.module.user.dto.UserDto;
import com.wheeloffortune.module.user.dto.UserForm;
import com.wheeloffortune.module.user.service.UserService;
import com.wheeloffortune.module.word.dto.WordDto;
import com.wheeloffortune.module.word.service.WordService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WOTService {

    private static final Integer BAISICPOINTVALUE = 10;

    @Autowired
    private WOTRepository repository;

    @Autowired
    private WOTSmartMapper mapper;

    @Autowired
    private WordService wordService;

    @Autowired
    private UserService userService;

    @Autowired
    private Random random ;




    public WOTDto getOne(String uuid){
        return mapper.map(
                repository.findOneByUuid(uuid)
        );
    }

    public List<WOTDto> getAll(){
        return mapper.map(
                repository.findAll()
        );
    }

    public WOTDto create(WOTForm form){
        WOTEntity game = mapper.map(form);
        return mapper.map(
                repository.saveAndFlush(game)
        );
    }

    public WOTDto update(String uuid, WOTForm form){
        WOTEntity fromDB = repository.findOneByUuid(uuid);
        WOTEntity fromForm = mapper.map(form);
        fromDB.setPlayerOneScore(fromForm.getPlayerOneScore())
                .setPlayerTwoScore(fromForm.getPlayerTwoScore())
                .setCurrentWordState(fromForm.getCurrentWordState())
                .setTurn(fromForm.getTurn());
        if(fromForm.getPlayers().isEmpty()) {

        }else{
            fromDB.setPlayers(fromForm.getPlayers());
        }
        if(fromForm.getPlayers().isEmpty()) {

        }else{
            fromDB.setWordEntity(fromForm.getWordEntity());
        }
        return  mapper.map(
                repository.saveAndFlush(fromDB)
        );
    }

    public void delete(String uuid){
        repository.delete(
                repository.findOneByUuid(uuid)
        );
    }

    public WOTDto init(List<String> users) {
        /*userService.create(new UserForm().setUsername("Player1").setGames(new HashSet<>()));
        userService.create(new UserForm().setUsername("Player2").setGames(new HashSet<>()));*/
        WordDto chosenWord = random.generateRNGWord();
        return create(new WOTForm()
                .setPlayerOneScore(0)
                .setPlayerTwoScore(0)
                .setCurrentWordState(chosenWord.getWord().replaceAll("[A-Za-z0-9żźćńółęąśŻŹĆĄŚĘŁÓŃ@]", "_"))
                .setTurn(TurnEnum.PLAYER1)
                .setPlayersUuid(new HashSet<>(users))
                .setWordUuid(chosenWord.getUuid())
        );
    }

    public String run(String uuid, String letter) {
        WOTDto game = getOne(uuid);
        if(game.getCurrentWordState().equals(wordService.getOne(game.getWordUuid()).getWord())){
            return "Game Over, Player: " + game.getTurn().name() + " Won, Score: Player 1 - " + game.getPlayerOneScore() + " Player 2 - " + game.getPlayerTwoScore();
        }
        if(Validator.validate(letter)) {
            if(Confirm.letterIsLetterInWord(letter, wordService.getOne(game.getWordUuid()).getWord())){
                WOTForm form = new WOTForm();
                form.setPlayersUuid(game.getPlayersUuid());
                TurnEnum current = game.getTurn();
                switch (current){
                    case PLAYER1:
                        form.setPlayerOneScore(game.getPlayerOneScore() + BAISICPOINTVALUE);
                        form.setPlayerTwoScore(game.getPlayerTwoScore());
                        break;
                    case PLAYER2:
                        form.setPlayerTwoScore(game.getPlayerTwoScore() + BAISICPOINTVALUE);
                        form.setPlayerOneScore(game.getPlayerOneScore());
                        break;
                }
                form.setTurn(changeTurn(current));
                form.setCurrentWordState(fillOutCurrentWordState(letter, game));
                form.setWordUuid(game.getWordUuid());
                update(uuid,form);
                return "Correct";
            }
            return "Letter Dose Not Exist";
        }
        return "Incorrect Input";
    }

    private String fillOutCurrentWordState(String letter,  WOTDto game) {
        char[] chars = game.getCurrentWordState().toCharArray();
        String word = wordService.getOne(game.getWordUuid()).getWord();
        for (int i = 0; i < wordService.getOne(game.getWordUuid()).getWord().length(); i++) {
            if(String.valueOf(word.charAt(i)).equalsIgnoreCase(letter)){
                chars[i] = letter.charAt(0);
            }
        }
        return String.valueOf(chars);
    }

    private TurnEnum changeTurn(TurnEnum turn) {
        switch (turn){
            case PLAYER1:
                return TurnEnum.PLAYER2;
            case PLAYER2:
                return TurnEnum.PLAYER1;
        }
        return null;
    }
}
