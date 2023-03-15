package com.example.timedeal.dto.product.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateProductSale {
    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}
