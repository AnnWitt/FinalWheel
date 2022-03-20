package com.wheeloffortune.core.engine;

import com.wheeloffortune.core.exeptions.NoLetterException;
import com.wheeloffortune.core.exeptions.NoWordException;

import java.util.Arrays;

public class Confirm {

    private static String[] prepareWord(String word){
        return word.toLowerCase().split("");
    }

    public static boolean letterIsLetterInWord(String letter, String word) throws NoWordException, NoLetterException {
        /*if(word.isBlank() || word.isEmpty()){
            throw new NoWordException("word is empty/blank");
        }
        if(letter.isBlank() || letter.isEmpty()){
            throw new NoLetterException("letter is empty/blank");
        }*/
        return Arrays.asList(prepareWord(word)).contains(letter.toLowerCase());
    }
}
