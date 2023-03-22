package com.example.timedeal.domain.purchase;

import com.example.timedeal.domain.product.Product;
import com.example.timedeal.domain.user.User;
import com.example.timedeal.dto.purchase.response.CreatePurchaseResponse;
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
