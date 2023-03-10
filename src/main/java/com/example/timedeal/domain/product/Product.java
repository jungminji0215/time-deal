package com.example.timedeal.domain.product;

import com.example.timedeal.dto.product.request.ProductCreateRequest;
import com.example.timedeal.dto.product.request.ProductUpdateRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    int price;

    int stockQuantity;

    @ColumnDefault("false")
    boolean isDeleted;

    @Builder
    public Product(ProductCreateRequest request){
        this.name = request.getName();
        this.price = request.getPrice();
        this.stockQuantity = request.getStockQuantity();
    }

    public void update(ProductUpdateRequest request) {
        this.name = request.getName();
        this.price = request.getPrice();
        this.stockQuantity = request.getStockQuantity();
    }

    public void delete() {
        this.isDeleted = true;
    }
}
