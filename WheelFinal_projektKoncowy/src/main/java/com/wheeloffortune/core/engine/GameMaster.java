package com.wheeloffortune.core.engine;

import com.wheeloffortune.module.word.dto.WordDto;

public class GameMaster {
    Random random = new Random();
    final WordDto chosenWord = random.generateRNGWord().orElseThrow(() -> new RuntimeException("word has not been chosen"));

}
