package com.example.timedeal.service.product.impl;

import com.example.timedeal.domain.product.Product;
import com.example.timedeal.domain.product.ProductRepository;
import com.example.timedeal.domain.product.sale.ProductSale;
import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import com.example.timedeal.dto.product.response.CreateProductResponse;
import com.example.timedeal.dto.product.response.DeleteProductResponse;
import com.example.timedeal.dto.product.response.GetProductResponse;
import com.example.timedeal.dto.product.response.UpdateProductResponse;
import com.example.timedeal.exception.ErrorCode;
import com.example.timedeal.exception.TimeDealException;
import com.example.timedeal.service.product.ProductService;
import com.example.timedeal.utils.DiscountProduct;
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
    @Transactional(readOnly = true)
    public List<GetProductResponse> list() {
        return productRepository.findAll().stream()
                .map(GetProductResponse::toGetResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public GetProductResponse findOne(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.PRODUCT_NOT_FOUND, "상품 아이디 : " + productId));
        return GetProductResponse.toGetResponse(product);
    }

    @Override
    @Transactional
    public CreateProductResponse create(CreateProductRequest request) {
        Product product = Product.of(request);

        int discountPrice = DiscountProduct.calculateProductSale(request.getPrice(), request.getProductSale().getDiscount());
        product.addSaleInfo(ProductSale.of(request.getProductSale(), discountPrice));

        return CreateProductResponse.toCreateResponse(productRepository.save(product));
    }

    @Override
    @Transactional
    public UpdateProductResponse update(UpdateProductRequest request, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.PRODUCT_NOT_FOUND, "상품 아이디 : " + productId));
        product.update(request);

        return UpdateProductResponse.toUpdateResponse(product);
    }

    @Override
    @Transactional
    public DeleteProductResponse delete(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.PRODUCT_NOT_FOUND, "상품 아이디 : " + productId));
        product.delete();

        return DeleteProductResponse.toDeleteResponse(product);

    }




}
