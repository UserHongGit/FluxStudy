package com.cn.fluxstudy.service;

import com.cn.fluxstudy.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getUserById(Integer id);

    Flux<User> getUsers();

    Mono<User> saveUser(Mono<User> monoUser);
}
