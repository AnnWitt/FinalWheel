package com.wheeloffortune;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GameBootController {

    @GetMapping("/")
    public String getHome() {
        return "Game.html";
    }
}
