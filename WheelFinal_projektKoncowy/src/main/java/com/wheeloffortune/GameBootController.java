package com.wheeloffortune;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GameBootController {

    @GetMapping("/")
    public String getHome() {
        return "front/IndexWheel.html";
    }

    @GetMapping("/game")
    public String getGame() {
        return "ront/fragments/dynamic/dynamicElements/game.html";
    }

    @GetMapping("/player")
    public String getPlayer() {
        return "ront/fragments/dynamic/dynamicElements/player.html";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "ront/fragments/dynamic/dynamicElements/admin.html";
    }

    @GetMapping("/score")
    public String getScore() {
        return "ront/fragments/dynamic/dynamicElements/scores.html";
    }

    @GetMapping("/default")
    public String getDefault() {
        return "front/fragments/dynamic/dynamicElements/default.html";
    }

    @GetMapping("/dynamic")
    public String getDynamic() {
        return "front/fragments/layout/dynamic.html";
    }


}
