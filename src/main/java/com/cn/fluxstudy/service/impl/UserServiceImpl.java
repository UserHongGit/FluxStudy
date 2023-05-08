package com.cn.fluxstudy.service.impl;

import com.cn.fluxstudy.entity.User;
import com.cn.fluxstudy.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    static List<User> users = new ArrayList<>();
    {
        users.add(new User("张三","男","1"));
        users.add(new User("李四","女","2"));
        users.add(new User("王五","男","3"));
    }

    @Override
    public Mono<User> getUserById(Integer id) {
        return Mono.justOrEmpty(users.get(id));
    }

    @Override
    public Flux<User> getUsers() {
        return Flux.fromIterable(users);
    }

    @Override
    public Mono<User> saveUser(Mono<User> monoUser) {
        return monoUser.doOnNext(person -> {
            users.add(person);
        });
    }
}
