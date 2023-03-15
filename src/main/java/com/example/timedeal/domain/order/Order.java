package com.example.timedeal.domain.order;

import com.example.timedeal.domain.product.Product;
import com.example.timedeal.domain.user.User;
import com.example.timedeal.dto.order.response.CreateOrderResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// todo 클래스명 의미있게 변경 UserProduct -> Order
@NoArgsConstructor
@Getter
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    public static Order createOrder(User user, Product product) {
        Order order = new Order();
        order.user = user;
        user.addOrder(order);
        order.product = product;
        product.addOrder(order);
        return order;
    }

    public CreateOrderResponse toResponse() {
        return CreateOrderResponse.builder()
                .userId(user.getId())
                .productId(product.getId())
                .build();
    }
}
