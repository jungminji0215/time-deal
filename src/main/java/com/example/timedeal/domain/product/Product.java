package com.example.timedeal.domain.product;

import com.example.timedeal.domain.product.sale.ProductSale;
import com.example.timedeal.domain.purchase.Purchase;
import com.example.timedeal.dto.product.request.CreateProductRequest;
import com.example.timedeal.dto.product.request.UpdateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ColumnDefault("false")
    boolean isDeleted;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    // soft delete
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_sale_id")
    private ProductSale productSale;

    @PrePersist
    void registeredAt(){
        this.registeredAt = LocalDateTime.now();
    }

    public static Product of(CreateProductRequest request){
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .build();
    }

    public void update(UpdateProductRequest request) {
        this.name = request.getName();
        this.price = request.getPrice();
        this.stockQuantity = request.getStockQuantity();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now();
    }

    public void checkStockQuantity() {
        if(this.stockQuantity == 0){
            throw new IllegalArgumentException("재고가 없습니다.");
        }
        this.stockQuantity--;
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
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
