package com.example.timedeal.product.domain;

import com.example.timedeal.timedeal.domain.TimeDeal;
import com.example.timedeal.purchase.domain.Purchase;
import com.example.timedeal.product.dto.request.CreateProductRequest;
import com.example.timedeal.product.dto.request.UpdateProductRequest;
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

    @ColumnDefault("false")
    boolean isDeleted;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    // soft delete
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<TimeDeal> timeDeal = new ArrayList<>();

    @PrePersist
    void registeredAt(){
        this.registeredAt = LocalDateTime.now();
    }

    public static Product of(CreateProductRequest request){
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }

    public void update(UpdateProductRequest request) {
        this.name = request.getName();
        this.price = request.getPrice();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now();
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }

    public void addTimeDeal(TimeDeal timeDeal) {
        this.timeDeal.add(timeDeal);
        timeDeal.addProduct(this);
    }
}
