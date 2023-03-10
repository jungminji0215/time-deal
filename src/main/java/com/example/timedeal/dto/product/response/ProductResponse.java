package com.example.timedeal.dto.product.response;

import com.example.timedeal.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {
    Long id;

    String name;

    int price;

    int stockQuantity;

    boolean isDeleted;

    @Builder
    public ProductResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
        this.isDeleted = product.isDeleted();
    }
}