package com.example.timedeal.user.dto.request;

import com.example.timedeal.user.enumeration.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String name;

    private String password;

    private UserType type;
}
