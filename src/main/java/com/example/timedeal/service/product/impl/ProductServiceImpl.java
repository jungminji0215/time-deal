package com.example.timedeal.service.product.impl;

import com.example.timedeal.utils.DiscountProduct;
import com.example.timedeal.domain.product.Product;
import com.example.timedeal.domain.product.ProductRepository;
import com.example.timedeal.domain.product.sale.ProductSale;
import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import com.example.timedeal.dto.product.response.CreateProductResponse;
import com.example.timedeal.dto.product.response.GetProductResponse;
import com.example.timedeal.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = request.toEntity(request);

        int discountPrice = DiscountProduct.calculateProductSale(request.getPrice(), request.getProductSale().getDiscount());
        product.addSaleInfo(new ProductSale(request.getProductSale(), discountPrice));

        return new CreateProductResponse(productRepository.save(product));
    }

    @Override
    @Transactional
    public void updateProduct(UpdateProductRequest request, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new IllegalArgumentException("상품을 찾을 수 없습니다. id:" + productId));
        product.update(request);
    }

    @Override
    @Transactional
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new IllegalArgumentException("상품을 찾을 수 없습니다. id:" + productId));
        product.delete();
    }

    @Override
    @Transactional(readOnly = true)
    public GetProductResponse getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new IllegalArgumentException("상품을 찾을 수 없습니다. id:" + productId));
        return new GetProductResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetProductResponse> listProduct() {
        return productRepository.findAll().stream()
                .map(GetProductResponse::new)
                .collect(Collectors.toList());
    }
}
