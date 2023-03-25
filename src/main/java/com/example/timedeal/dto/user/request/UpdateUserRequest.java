package com.example.timedeal.dto.user.request;

import com.example.timedeal.enumeration.UserType;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String name;

    private String password;

    private UserType type;
}
