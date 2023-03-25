package com.example.timedeal.mock;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.dto.user.request.CreateUserRequest;

public class UserTest {
    public static User get(CreateUserRequest request){
        return User.builder()
                .name(request.getName())
                .password(request.getPassword())
                .type(request.getType())
                .build();
    }
}
