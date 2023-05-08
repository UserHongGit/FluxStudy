package com.cn.fluxstudy.controller;

import com.cn.fluxstudy.entity.User;
import com.cn.fluxstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/{id}")
    public Mono<User> getUserById(@PathVariable("id")Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public Flux<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/saveuser")
    public Mono<User> saveUser(@RequestBody User user){
        Mono<User> just = Mono.just(user);

        return userService.saveUser(just);
    }


}
