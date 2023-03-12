package com.example.timedeal.dto.user.response;

import lombok.Builder;
import lombok.Data;

@Data
public class DeleteUserResponse {
    private Long id;

    private boolean quit;

    @Builder
    public DeleteUserResponse(Long id, boolean quit) {
        this.id = id;
        this.quit = quit;
    }
}
