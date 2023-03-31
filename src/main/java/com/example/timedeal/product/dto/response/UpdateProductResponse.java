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

    private int stockQuantity;

    private CreateProductSaleResponse saleInfo;

    public static UpdateProductResponse toUpdateResponse(Product product){
        return UpdateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .saleInfo(product.getProductSale().toResponse())
                .build();
    }
}
