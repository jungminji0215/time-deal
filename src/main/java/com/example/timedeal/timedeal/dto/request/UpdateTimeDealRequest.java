package com.example.timedeal.timedeal.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateTimeDealRequest {
    private Long productId;

    private String name;

    private int stock;

    private int discount;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}
