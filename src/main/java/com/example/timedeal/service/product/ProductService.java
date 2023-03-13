package com.example.timedeal.service.product;

import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import com.example.timedeal.dto.product.response.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(CreateProductRequest request);

    void updateProduct(UpdateProductRequest request, Long productId);

    void deleteProduct(Long productId);

    ProductResponse getProduct(Long productId);

    List<ProductResponse> listProduct();
}
