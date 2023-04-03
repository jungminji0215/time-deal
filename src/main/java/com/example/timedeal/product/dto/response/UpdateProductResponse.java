package com.example.timedeal.product.dto.response;

import com.example.timedeal.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UpdateProductResponse {
    private Long id;

    private String name;

    private int price;

    private int stock;

    private boolean isDeleted;

    public static UpdateProductResponse toUpdateResponse(Product product){
        return UpdateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .isDeleted(product.isDeleted())
                .build();
    }
}
