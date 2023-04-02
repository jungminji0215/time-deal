package com.example.timedeal.product.dto.request;

import lombok.Getter;

@Getter
public class CreateProductRequest {
    private String name;

    private int price;
}