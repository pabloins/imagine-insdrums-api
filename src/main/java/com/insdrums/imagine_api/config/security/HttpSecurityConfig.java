package com.insdrums.imagine_api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider daoAuthProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf( csrfConfig -> csrfConfig
                        .ignoringRequestMatchers("/h2-console/**")
                        .disable() )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .sessionManagement( sessMangConfig -> sessMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS) )
                .authenticationProvider(daoAuthProvider)
                .authorizeHttpRequests( authReqConfig -> {

                    //Aca puedes declarar los endpoints para que esten habilitados en el spring security
                    authReqConfig.requestMatchers(HttpMethod.POST, "/users").permitAll();
                    authReqConfig.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    authReqConfig.requestMatchers(HttpMethod.POST, "/auth/validate").permitAll();
                    authReqConfig.requestMatchers("/h2-console/**").permitAll();

                    authReqConfig.anyRequest().authenticated();
                } )
                .build();
    }
}
