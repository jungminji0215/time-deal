package com.example.timedeal.product.dto.response;

import com.example.timedeal.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class CreateProductResponse {
    private Long id;

    private String name;

    private int price;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private boolean isDeleted;

    public static CreateProductResponse toCreateResponse(Product product){
        return CreateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .registeredAt(product.getRegisteredAt())
                .updatedAt(product.getUpdatedAt())
                .deletedAt(product.getDeletedAt())
                .isDeleted(product.isDeleted())
                .build();
    }
}
