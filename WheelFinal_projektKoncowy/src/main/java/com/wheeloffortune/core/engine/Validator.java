package com.wheeloffortune.core.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validate(String letter) {
        Pattern pattern = Pattern.compile("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ@]");
        if(letter == null){
            return false;
        }
        Matcher matcher = pattern.matcher(letter);
        return matcher.matches();
    }
}
