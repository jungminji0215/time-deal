package com.example.timedeal.service;

import com.example.timedeal.dto.product.request.ProductCreateRequest;
import com.example.timedeal.dto.product.request.ProductUpdateRequest;
import com.example.timedeal.dto.product.response.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductCreateRequest request);

    void updateProduct(ProductUpdateRequest request, Long productId);

    void deleteProduct(Long productId);

    ProductResponse getProduct(Long productId);

    List<ProductResponse> listProduct();
}
