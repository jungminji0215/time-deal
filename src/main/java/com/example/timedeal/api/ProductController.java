package com.example.timedeal.api;


import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import com.example.timedeal.service.product.ProductService;
import com.example.timedeal.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseResult<?> createProduct(@RequestBody CreateProductRequest request){
        return new ResponseResult<>(productService.createProduct(request));
    }

    @GetMapping("/products")
    public ResponseResult<?> listProduct(){
        return new ResponseResult<>(productService.listProduct());

    }

    @GetMapping("/products/{productId}")
    public ResponseResult<?> getProduct( @PathVariable Long productId){
        return new ResponseResult<>(productService.getProduct(productId));
    }

    @PutMapping("/products/{productId}")
    public void updateProduct(
            @RequestBody UpdateProductRequest request,
            @PathVariable Long productId
    ){
        productService.updateProduct(request, productId);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(
            @PathVariable Long productId
    ){
        productService.deleteProduct(productId);
    }


}