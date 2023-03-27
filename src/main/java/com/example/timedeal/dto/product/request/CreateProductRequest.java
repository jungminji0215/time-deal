package com.example.timedeal.dto.product.request;


import lombok.Getter;

@Getter
public class CreateProductRequest {
    private String name;

    private int price;

    private int stockQuantity;

    private CreateProductSaleRequest productSale;
}