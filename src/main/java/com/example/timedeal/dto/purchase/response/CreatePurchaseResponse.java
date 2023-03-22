package com.example.timedeal.dto.purchase.response;

import lombok.Builder;
import lombok.Data;

@Data
public class CreatePurchaseResponse {
    private Long userId;
    private Long productId;

    @Builder
    public CreatePurchaseResponse(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}
