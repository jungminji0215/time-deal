package com.example.timedeal.dto.user.request;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.enumeration.UserType;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    String name;

    UserType type;

    public User toEntity() {
        return User.builder()
                .name(name)
                .type(type)
                .build();
    }
}
