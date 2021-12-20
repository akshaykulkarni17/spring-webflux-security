package com.example.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("home")
public class SecurityController {

    @GetMapping("admin")
    public Mono<String> adminResponse(){
        return Mono.just("Admin Home");
    }

    @GetMapping("user")
    public Mono<String> userResponse(){
        return Mono.just("User Home");
    }

    @GetMapping("any")
    public Mono<String> anyResponse(){
        return Mono.just("Guest Home");
    }
}
