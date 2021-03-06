package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class SecurityService implements ReactiveUserDetailsService {

    @Autowired
    private Map<String,UserDetails> map;

    @Override
    public Mono<UserDetails> findByUsername(String userName) {
        return Mono.just(this.map.get(userName));
    }
}
