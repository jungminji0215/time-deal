package com.example.timedeal.dto.product.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateProductSaleResponse {
    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    private int discount;

    private int discountPrice;

    public CreateProductSaleResponse(LocalDateTime startedAt, LocalDateTime finishedAt, int discount, int discountPrice) {
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.discount = discount;
        this.discountPrice = discountPrice;
    }
}
