package com.example.timedeal.domain.product.sale;

import com.example.timedeal.domain.product.Product;
import com.example.timedeal.dto.product.request.CreateProductSale;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public void addProduct(Product product) {
        this.product = product;
    }

    public ProductSale(CreateProductSale request) {
        this.startedAt = request.getStartedAt();
        this.finishedAt = request.getFinishedAt();
    }
}
