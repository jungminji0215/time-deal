package com.example.timedeal.service.product;

import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import com.example.timedeal.dto.product.response.CreateProductResponse;
import com.example.timedeal.dto.product.response.GetProductResponse;

import java.util.List;

public interface ProductService {
    CreateProductResponse createProduct(CreateProductRequest request);

    void updateProduct(UpdateProductRequest request, Long productId);

    void deleteProduct(Long productId);

    GetProductResponse getProduct(Long productId);

    List<GetProductResponse> listProduct();
}
