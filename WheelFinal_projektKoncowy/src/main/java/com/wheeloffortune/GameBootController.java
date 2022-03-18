package com.wheeloffortune;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GameBootController {

    @GetMapping("/")
    public String getHome() {
        return "front/IndexWheel.html";
    }

    //budowanie szkieletu aby tylko poparować. Do powielenia w odpowiednich miejscach w IndexWheel po uporządkowaniu sprawy css
    @GetMapping("/Experimental.html")
    public String getHomeExp() {
        return "front/Experimental.html";
    }
}
