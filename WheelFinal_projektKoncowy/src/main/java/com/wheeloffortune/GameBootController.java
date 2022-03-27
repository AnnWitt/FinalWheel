package com.wheeloffortune;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class GameBootController {

    @GetMapping("/")
    public String getHome() {
        return "front/IndexWheel.html";
    }

    @GetMapping("/IndexWheel.html")
    public String getHomeTemp() {
        return "front/IndexWheel.html";
    }

    @GetMapping("/game")
    public String getGame() {
        return "front/fragments/dynamic/dynamicElements/game.html";
    }

    @GetMapping("/player")
    public String getPlayer() {
        return "front/fragments/dynamic/dynamicElements/player.html";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "front/fragments/dynamic/dynamicElements/admin.html";
    }

    @GetMapping("/score")
    public String getScore() {
        return "front/fragments/dynamic/dynamicElements/scores.html";
    }

    @GetMapping("/default")
    public String getDefault() {
        return "front/fragments/dynamic/dynamicElements/default.html";
    }

    @GetMapping("/dynamic")
    public String getDynamic(Model model) {
        List<String> alphabet = new ArrayList<>();
        alphabet.addAll(Arrays.asList("A", "Ą", "B", "C", "Ć", "D", "E", "Ę", "F", "G", "H", "I",
                "J", "K", "L", "Ł", "M", "N", "Ń", "O", "Ó", "Q", "P", "R", "S", "Ś", "T", "U", "W", "X", "Y", "Z", "Ż", "Ź"));
        model.addAttribute("letter",alphabet);
        return "front/fragments/layout/dynamic.html";
    }

    @GetMapping("/test")
    public String getTest() {
        return "notes/test.html";
    }

    @GetMapping("/panel")
    public String preparePanel(Model model){
        List<String> alphabet2 = new ArrayList<>();
        alphabet2.addAll(Arrays.asList("A", "Ą", "B", "C", "Ć", "D", "E", "Ę", "F", "G", "H", "I",
                "J", "K", "L", "Ł", "M", "N", "Ń", "O", "Ó", "Q", "P", "R", "S", "Ś", "T", "U", "W", "X", "Y", "Z", "Ż", "Ź"));
        model.addAttribute("letter",alphabet2);

        return "front/fragments/dynamic/gameElements/letters.html";
    }


/*    {
        List<String> alphabet = new ArrayList<>();
        alphabet.addAll(Arrays.asList("A", "Ą", "B", "C", "Ć", "D", "E", "Ę", "F", "G", "H", "I",
                "J", "K", "L", "Ł", "M", "N", "Ń", "O", "Ó", "Q", "P", "R", "S", "Ś", "T", "U", "W", "X", "Y", "Z", "Ż", "Ź"));
    }*/

}
