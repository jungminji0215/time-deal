package com.example.timedeal.product.dto.response;

import com.example.timedeal.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class GetProductResponse {
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private boolean isDeleted;

    private CreateProductSaleResponse saleInfo;

    public static GetProductResponse toGetResponse(Product product){
        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .registeredAt(product.getRegisteredAt())
                .updatedAt(product.getUpdatedAt())
                .deletedAt(product.getDeletedAt())
                .saleInfo(product.getProductSale().toResponse())
                .build();
    }
}