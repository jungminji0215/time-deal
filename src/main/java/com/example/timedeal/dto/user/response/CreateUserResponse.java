package com.example.timedeal.dto.user.response;

import com.example.timedeal.enumeration.UserType;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateUserResponse {
    private Long id;

    private String name;

    private UserType type;

    private boolean quit;

    @Builder
    public CreateUserResponse(Long id, String name, UserType type, boolean quit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quit = quit;
    }
}
