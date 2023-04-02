package com.example.timedeal.purchase.dto.response;

import com.example.timedeal.purchase.domain.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CreatePurchaseResponse {
    private Long userId;
    private Long productId;

    public static CreatePurchaseResponse toCreateResponse(Purchase purchase) {
        return CreatePurchaseResponse.builder()
                .userId(purchase.getUser().getId())
                .productId(purchase.getProduct().getId())
                .build();
    }
}
