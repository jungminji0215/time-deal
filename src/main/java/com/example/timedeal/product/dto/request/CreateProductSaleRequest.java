package com.example.timedeal.product.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateProductSaleRequest {
    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    private int discount;
}
