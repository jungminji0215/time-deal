package com.example.timedeal.dto.product.response;

import com.example.timedeal.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetProductResponse {
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    private boolean isDeleted;

    private CreateProductSaleResponse saleInfo;

    @Builder
    public GetProductResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
        this.isDeleted = product.isDeleted();
        this.saleInfo = product.getProductSale().toResponse();
    }
}