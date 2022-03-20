package com.wheeloffortune.module.user.controller;

import com.wheeloffortune.module.user.dto.UserDto;
import com.wheeloffortune.module.user.dto.UserForm;
import com.wheeloffortune.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService service;

    @GetMapping("/api/users")
    public List<UserDto> getUsers(){
        return service.getAll();
    }
    @GetMapping("/api/user/{uuid}")
    public UserDto getUser(@PathVariable String uuid){
        return service.getOne(uuid);
    }
    @PostMapping("/api/user")
    public UserDto createUser(@RequestBody @Valid UserForm form){
        return service.create(form);
    }
    @PutMapping("/api/user/{uuid}")
    public UserDto updateUser(@RequestBody @Valid UserForm form, @PathVariable String uuid){ return service.update(uuid,form);}
    @DeleteMapping("/api/user/{uuid}")
    public void deleteUser(@PathVariable String uuid){
        service.delete(uuid);
    }

}
