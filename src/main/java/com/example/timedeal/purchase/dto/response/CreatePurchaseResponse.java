package com.example.timedeal.purchase.dto.response;

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
