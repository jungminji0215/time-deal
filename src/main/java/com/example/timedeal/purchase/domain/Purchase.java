package com.example.timedeal.purchase.domain;

import com.example.timedeal.product.domain.Product;
import com.example.timedeal.timedeal.domain.TimeDeal;
import com.example.timedeal.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public static Purchase of(User user, Product product, TimeDeal timeDeal, int cnt) {
        timeDeal.checkTime();

        product.decreaseStock(cnt);

        return Purchase.builder()
                .user(user)
                .product(product)
                .build();
    }
}
