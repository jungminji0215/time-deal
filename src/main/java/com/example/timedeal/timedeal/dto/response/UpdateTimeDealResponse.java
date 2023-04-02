package com.example.timedeal.timedeal.dto.response;

import com.example.timedeal.timedeal.domain.TimeDeal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class UpdateTimeDealResponse {
    private Long id;

    private Long productId;

    private String name;

    private int stock;

    private int discount;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    private boolean isFinished;

    public static UpdateTimeDealResponse toUpdateResponse(TimeDeal timeDeal){
        return UpdateTimeDealResponse.builder()
                .id(timeDeal.getId())
                .productId(timeDeal.getProduct().getId())
                .name(timeDeal.getName())
                .stock(timeDeal.getStock())
                .discount(timeDeal.getDiscount())
                .startedAt(timeDeal.getStartedAt())
                .finishedAt(timeDeal.getFinishedAt())
                .isFinished(timeDeal.isFinished())
                .build();
    }
}
