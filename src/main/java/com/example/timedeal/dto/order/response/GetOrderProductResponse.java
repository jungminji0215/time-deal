package com.example.timedeal.dto.order.response;

import lombok.Getter;

@Getter
public class GetOrderProductResponse {
    private Long id;

    private String name;

    public GetOrderProductResponse(Long productId, String name) {
        this.id = productId;
        this.name = name;
    }
}