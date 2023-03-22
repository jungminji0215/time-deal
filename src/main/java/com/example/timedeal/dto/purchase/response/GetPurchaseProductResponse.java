package com.example.timedeal.dto.purchase.response;

import lombok.Getter;

@Getter
public class GetPurchaseProductResponse {
    private Long id;

    private String name;

    public GetPurchaseProductResponse(Long productId, String name) {
        this.id = productId;
        this.name = name;
    }
}