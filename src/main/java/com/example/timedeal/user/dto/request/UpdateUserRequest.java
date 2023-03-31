package com.example.timedeal.user.dto.request;

import com.example.timedeal.user.enumeration.UserType;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String name;

    private String password;

    private UserType type;
}
