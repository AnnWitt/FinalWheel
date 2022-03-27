package com.wheeloffortune;

import com.wheeloffortune.module.user.dto.UserDto;
import com.wheeloffortune.module.user.dto.UserForm;
import com.wheeloffortune.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Controller
public class GameBootController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getHome() {
        return "front/IndexWheel.html";
    }

    @GetMapping("/IndexWheel.html")
    public String getHomeTemp() {
        return "front/IndexWheel.html";
    }

    @GetMapping("/player")
    public String getPlayer(Model model) {
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("users",userService.getAll());
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

        String word="test";
        char emptyButtons='x';
/*        wordbuttons hasło - znane*/
        List<Character> wordButtons = new ArrayList<>();
        List<Character> borderButtons = new ArrayList<>();
        borderButtons.add(emptyButtons);
        wordButtons.add(emptyButtons);
        for (char ch : word.toUpperCase(Locale.ROOT).toCharArray()) {
            wordButtons.add(ch);
            borderButtons.add('x');
        }
        wordButtons.add(emptyButtons);
        borderButtons.add(emptyButtons);
        model.addAttribute("empty",borderButtons);
        model.addAttribute("wordknown",wordButtons);

        return "front/fragments/layout/dynamic.html";
    }

    @PostMapping(path ="/game/user")
    public String createUser(UserForm form){
        UserDto newUser = userService.create(form);
        return "redirect:/player";
    }

}
