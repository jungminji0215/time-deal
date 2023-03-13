package com.example.timedeal.domain.product;

import com.example.timedeal.domain.order.Order;
import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ColumnDefault("false")
    boolean isDeleted;

    @OneToMany(mappedBy = "product")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Product(CreateProductRequest request){
        this.name = request.getName();
        this.price = request.getPrice();
        this.stockQuantity = request.getStockQuantity();
    }

    public void update(UpdateProductRequest request) {
        this.name = request.getName();
        this.price = request.getPrice();
        this.stockQuantity = request.getStockQuantity();
    }

    public void delete() {
        this.isDeleted = true;
    }

    public void checkStockQuantity() {
        if(this.stockQuantity == 0){
            throw new IllegalArgumentException("재고가 없습니다.");
        }
        this.stockQuantity--;
    }
}
