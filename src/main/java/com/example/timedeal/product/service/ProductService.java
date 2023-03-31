package com.example.timedeal.product.service;

import com.example.timedeal.product.dto.request.CreateProductRequest;
import com.example.timedeal.product.dto.request.UpdateProductRequest;
import com.example.timedeal.product.dto.response.CreateProductResponse;
import com.example.timedeal.product.dto.response.DeleteProductResponse;
import com.example.timedeal.product.dto.response.GetProductResponse;
import com.example.timedeal.product.dto.response.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    GetProductResponse findOne(Long productId);

    List<GetProductResponse> list();

    CreateProductResponse create(CreateProductRequest request);

    UpdateProductResponse update(UpdateProductRequest request, Long productId);

    DeleteProductResponse delete(Long productId);


}
