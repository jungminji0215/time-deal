package com.example.timedeal.timedeal.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTimeDealRequest {
    private Long productId;

    private String name;

    private int discount;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}
