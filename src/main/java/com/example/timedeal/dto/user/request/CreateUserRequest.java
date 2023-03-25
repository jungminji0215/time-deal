package com.example.timedeal.dto.user.request;

import com.example.timedeal.enumeration.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String name;

    private String password;

    private UserType type;
}
