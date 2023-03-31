package com.example.timedeal.product.controller;


import com.example.timedeal.product.dto.request.CreateProductRequest;
import com.example.timedeal.product.dto.request.UpdateProductRequest;
import com.example.timedeal.product.dto.response.CreateProductResponse;
import com.example.timedeal.product.dto.response.DeleteProductResponse;
import com.example.timedeal.product.dto.response.GetProductResponse;
import com.example.timedeal.product.dto.response.UpdateProductResponse;
import com.example.timedeal.product.service.ProductService;
import com.example.timedeal.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ApiResponse<List<GetProductResponse>> list(){
        return ApiResponse.success(productService.list());
    }

    @GetMapping("/{productId}")
    public ApiResponse<GetProductResponse> findOne(
            @PathVariable Long productId
    ) {
        return ApiResponse.success(productService.findOne(productId));
    }

    @PostMapping
    public ApiResponse<CreateProductResponse> create(
            @RequestBody CreateProductRequest request
    ){
        return ApiResponse.success(productService.create(request));
    }

    @PutMapping("/{productId}")
    public ApiResponse<UpdateProductResponse> update(
            @RequestBody UpdateProductRequest request,
            @PathVariable Long productId
    ){
        return ApiResponse.success(productService.update(request, productId));
    }

    @DeleteMapping("/{productId}")
    public ApiResponse<DeleteProductResponse> delete(
            @PathVariable Long productId
    ){
        return ApiResponse.success(productService.delete(productId));
    }
}