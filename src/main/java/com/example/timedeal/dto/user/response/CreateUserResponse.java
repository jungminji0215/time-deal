package com.example.timedeal.dto.user.response;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class CreateUserResponse {
    private Long id;

    private String name;

    private String password;

    private UserType type;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private boolean quit;

    public static CreateUserResponse toCreateResponse(User user){
        return CreateUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .type(user.getType())
                .registeredAt(user.getRegisteredAt())
                .updatedAt(user.getUpdatedAt())
                .deletedAt(user.getDeletedAt())
                .quit(user.isQuit())
                .build();
    }
}
