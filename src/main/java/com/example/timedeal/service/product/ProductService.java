package com.example.timedeal.service.product;

import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import com.example.timedeal.dto.product.response.CreateProductResponse;
import com.example.timedeal.dto.product.response.DeleteProductResponse;
import com.example.timedeal.dto.product.response.GetProductResponse;
import com.example.timedeal.dto.product.response.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    GetProductResponse findOne(Long productId);

    List<GetProductResponse> list();

    CreateProductResponse create(CreateProductRequest request);

    UpdateProductResponse update(UpdateProductRequest request, Long productId);

    DeleteProductResponse delete(Long productId);


}
