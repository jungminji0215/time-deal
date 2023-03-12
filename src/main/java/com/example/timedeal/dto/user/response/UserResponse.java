package com.example.timedeal.dto.user.response;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.enumeration.UserType;
import lombok.Builder;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;

    private String name;

    private UserType type;

    private boolean quit;

    @Builder
    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.type = user.getType();
        this.quit = user.isQuit();
    }
}
