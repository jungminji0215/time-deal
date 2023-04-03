package com.example.timedeal.product.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter // 테스트코드
@Getter
public class CreateProductRequest {
    private String name;

    private int stock;

    private int price;
}