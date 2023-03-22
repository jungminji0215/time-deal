package com.example.timedeal.dto.purchase.response;

import lombok.Getter;

@Getter
public class GetPurchaseUserResponse {
    private Long id;

    private String name;

    public GetPurchaseUserResponse(Long userId, String name) {
        this.id = userId;
        this.name = name;
    }
}