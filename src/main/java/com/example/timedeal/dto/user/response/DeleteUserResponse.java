package com.example.timedeal.dto.user.response;

import com.example.timedeal.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class DeleteUserResponse {
    private Long id;

    private LocalDateTime deletedAt;

    private boolean quit;

    public static DeleteUserResponse toDeleteResponse(User user) {
        return DeleteUserResponse.builder()
                .id(user.getId())
                .deletedAt(user.getDeletedAt())
                .quit(user.isQuit())
                .build();
    }
}
