package com.example.timedeal.user.dto.response;

import com.example.timedeal.user.enumeration.UserType;
import com.example.timedeal.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class GetUserResponse {
    private Long id;

    private String name;

    private String password;

    private UserType type;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private boolean quit;

    public static GetUserResponse toGetResponse(User user){
        return GetUserResponse.builder()
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
