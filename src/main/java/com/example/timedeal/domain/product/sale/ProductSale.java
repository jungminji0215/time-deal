package com.example.timedeal.domain.product.sale;

import com.example.timedeal.domain.product.Product;
import com.example.timedeal.dto.product.request.CreateProductSaleRequest;
import com.example.timedeal.dto.product.response.CreateProductSaleResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_sale_id")
    private Long id;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    private int discount;

    private int discountPrice;

    @OneToOne(mappedBy = "productSale", fetch = FetchType.LAZY)
    private Product product;

    public void addProduct(Product product) {
        this.product = product;
    }

    public ProductSale(CreateProductSaleRequest request, int discountPrice) {
        this.startedAt = request.getStartedAt();
        this.finishedAt = request.getFinishedAt();
        this.discount = request.getDiscount();
        this.discountPrice = discountPrice;
    }

    public CreateProductSaleResponse toResponse() {
        return new CreateProductSaleResponse(startedAt, finishedAt, discount, discountPrice);
    }
}
