package com.example.timedeal.dto.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    String name;

    int price;

    int stockQuantity;
}
