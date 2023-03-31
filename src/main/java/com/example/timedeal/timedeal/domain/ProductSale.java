package com.example.timedeal.timedeal.domain;

import com.example.timedeal.product.domain.Product;
import com.example.timedeal.product.dto.request.CreateProductSaleRequest;
import com.example.timedeal.product.dto.response.CreateProductSaleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public static ProductSale of(
            CreateProductSaleRequest request,
            int discountPrice
    ){
        return ProductSale.builder()
                .startedAt(request.getStartedAt())
                .finishedAt(request.getFinishedAt())
                .discount(request.getDiscount())
                .discountPrice(discountPrice)
                .build();
    }

    public CreateProductSaleResponse toResponse() {
        return new CreateProductSaleResponse(startedAt, finishedAt, discount, discountPrice);
    }
}
