package com.github.nicolasholanda.partiubackend.service;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    @Cacheable(value = "users", key = "#id")
    public UserRepresentation findUserById(String id) {
        return keycloak.realm(realm).users().get(id).toRepresentation();
    }
}
