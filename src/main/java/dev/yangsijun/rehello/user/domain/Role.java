package dev.yangsijun.rehello.user.domain;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String role;

    Role(String role) {
        this.role = role;
    }

}
