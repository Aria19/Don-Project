package com.example.donation.users.dao.enums;

import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.example.donation.users.dao.enums.Privilege.*;

@RequiredArgsConstructor
public enum Role {
    ADMIN(
        Set.of(READ_PRIVILEGE, WRITE_PRIVILEGE, UPDATE_PRIVILEGE, DELETE_PRIVILEGE)),
    USER(
        Set.of(READ_PRIVILEGE)
    );

    @Getter
    private final Set<Privilege> privileges;
}
