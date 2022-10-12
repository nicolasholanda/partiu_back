package com.github.nicolasholanda.partiubackend.model.builder;

import lombok.Builder;
import lombok.Getter;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.idm.UserRepresentation;

@Getter
public class LoggedUser extends UserRepresentation {

    @Builder
    public LoggedUser(String id, String firstName, String lastName, String username, String email) {
        super();
        this.id = id;
        this.email = email;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public static LoggedUser of(AccessToken token) {
        return new LoggedUser(token.getId(), token.getGivenName(), token.getFamilyName(), token.getPreferredUsername(), token.getEmail());
    }
}
