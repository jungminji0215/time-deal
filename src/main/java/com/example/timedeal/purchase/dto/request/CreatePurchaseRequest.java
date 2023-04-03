package com.example.timedeal.purchase.dto.request;

import lombok.Data;

@Data
public class CreatePurchaseRequest {
    private Long productId;

    // 임시
    private Long userId;

    private int cnt;
}
