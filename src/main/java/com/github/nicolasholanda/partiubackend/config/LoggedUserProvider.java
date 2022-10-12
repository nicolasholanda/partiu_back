package com.github.nicolasholanda.partiubackend.config;

import com.github.nicolasholanda.partiubackend.model.builder.LoggedUser;
import org.keycloak.KeycloakPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class LoggedUserProvider {

    @Bean
    @RequestScope
    public LoggedUser loggedUser() {
        var principal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var token = principal.getKeycloakSecurityContext().getToken();
        return LoggedUser.of(token);
    }

}
