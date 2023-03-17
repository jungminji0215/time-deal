package com.example.timedeal.dto.product.request;


import com.example.timedeal.domain.product.Product;
import lombok.Getter;

@Getter
public class CreateProductRequest {
    private String name;

    private int price;

    private int stockQuantity;

    private CreateProductSaleRequest productSale;

    public Product toEntity(CreateProductRequest request) {
        return Product.builder()
                .request(request)
                .build();
    }
}