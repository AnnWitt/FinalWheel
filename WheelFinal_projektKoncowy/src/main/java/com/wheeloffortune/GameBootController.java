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
        return "front/fragments/game.html";
    }

    @GetMapping("/player")
    public String getPlayer() {
        return "front/fragments/player.html";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "front/fragments/admin.html";
    }

    @GetMapping("/score")
    public String getScore() {
        return "front/fragments/scoreTable.html";
    }

    @GetMapping("/default")
    public String getDefault() {
        return "front/fragments/default.html";
    }

}
