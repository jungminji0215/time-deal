package com.example.timedeal.controller;


import com.example.timedeal.dto.product.request.ProductCreateRequest;
import com.example.timedeal.dto.product.request.ProductUpdateRequest;
import com.example.timedeal.dto.product.response.ProductResponse;
import com.example.timedeal.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductResponse getProduct( @PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/product")
    public void createProduct(@RequestBody ProductCreateRequest request){
        productService.createProduct(request);
    }

    @PutMapping("/product/{productId}")
    public void updateProduct(
            @RequestBody ProductUpdateRequest request,
            @PathVariable Long productId
    ){
        productService.updateProduct(request, productId);
    }

    @DeleteMapping("/product/{productId}")
    public void deleteProduct(
            @PathVariable Long productId
    ){
        productService.deleteProduct(productId);
    }

    @GetMapping("/product")
    public List<ProductResponse> listProduct(){
        return productService.listProduct();
    }
}