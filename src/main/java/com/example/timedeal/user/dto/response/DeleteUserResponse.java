package com.example.timedeal.user.dto.response;

import com.example.timedeal.user.domain.User;
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
