package com.example.timedeal.dto.product.request;


import com.example.timedeal.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductCreateRequest {
    String name;

    int price;

    int stockQuantity;

    public Product toEntity(ProductCreateRequest request) {
        return Product.builder()
                .request(request)
                .build();
    }
}