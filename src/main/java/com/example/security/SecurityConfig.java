package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security){
        return security
                .authorizeExchange()
                .pathMatchers("/home/user").hasAnyRole("USER","ADMIN")
                .pathMatchers("/home/admin").hasRole("ADMIN")
                .anyExchange()
                .authenticated()
                .and()
                .formLogin()
                .and().build();

    }
}
