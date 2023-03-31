package com.example.timedeal.purchase.dto.response;

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