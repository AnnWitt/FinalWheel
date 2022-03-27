package com.wheeloffortune.module.user.service;

import com.wheeloffortune.module.user.dto.UserDto;
import com.wheeloffortune.module.user.dto.UserForm;
import com.wheeloffortune.module.user.entity.UserEntity;
import com.wheeloffortune.module.user.mapper.UserMapper;
import com.wheeloffortune.module.user.reposytory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDto> getAll(){
        return UserMapper.map(
                repository.findAll()
        );
    }

    public UserDto getOne(String uuid){
        return UserMapper.map(
                repository.findOneByUuid(uuid)
        );
    }

    public UserDto getOneByUsername(String username){
        return UserMapper.map(
                repository.findOneByUsername(username)
        );
    }

    public UserDto create(UserForm form){
        UserEntity user = UserMapper.map(form);
        return UserMapper.map(
                repository.saveAndFlush(user)
        );
    }

    public UserDto update(String uuid, UserForm form){
        UserEntity fromDB = repository.findOneByUuid(uuid)
                .setUsername(form.getUsername());
        if(!form.getGames().isEmpty()){
            fromDB.setWheelOfFortune(form.getGames());
        }
        return UserMapper.map(
                repository.saveAndFlush(fromDB)
        );
    }

    public void delete(String uuid){
        repository.delete(
                repository.findOneByUuid(uuid)
        );
    }
}
