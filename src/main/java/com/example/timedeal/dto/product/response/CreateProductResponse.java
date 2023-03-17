package com.example.timedeal.dto.product.response;

import com.example.timedeal.domain.product.Product;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateProductResponse {
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    private CreateProductSaleResponse saleInfo;

    @Builder
    public CreateProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
        this.saleInfo = product.getProductSale().toResponse();
    }
}
