package com.example.timedeal.purchase.domain;

import com.example.timedeal.product.domain.Product;
import com.example.timedeal.purchase.dto.response.CreatePurchaseResponse;
import com.example.timedeal.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// todo 클래스명 의미있게 변경 UserProduct -> purchase
@NoArgsConstructor
@Getter
@Table(name = "purchase")
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

    public static Purchase createPurchase(User user, Product product) {
        Purchase purchase = new Purchase();
        purchase.user = user;
        purchase.product = product;
        product.addPurchase(purchase);
        return purchase;
    }

    public CreatePurchaseResponse toResponse() {
        return CreatePurchaseResponse.builder()
                .userId(user.getId())
                .productId(product.getId())
                .build();
    }
}
