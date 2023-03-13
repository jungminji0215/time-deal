package com.example.timedeal.dto.order.response;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateOrderResponse {
    private Long userId;
    private Long productId;

    @Builder
    public CreateOrderResponse(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}
