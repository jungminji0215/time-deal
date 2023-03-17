package com.example.timedeal.domain.product;

import com.example.timedeal.domain.order.Order;
import com.example.timedeal.domain.product.sale.ProductSale;
import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private ProductSale productSale;

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

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void addSaleInfo(ProductSale productSale) {
        this.productSale = productSale;
        productSale.addProduct(this);
    }

    public void checkTime() {
        if(productSale.getFinishedAt().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("특가시간이 지났습니다.");
        }
    }
}
