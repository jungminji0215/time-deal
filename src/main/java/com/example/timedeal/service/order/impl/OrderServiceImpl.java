package com.example.timedeal.service.order.impl;

import com.example.timedeal.domain.order.Order;
import com.example.timedeal.domain.order.OrderRepository;
import com.example.timedeal.domain.product.Product;
import com.example.timedeal.domain.product.ProductRepository;
import com.example.timedeal.domain.user.User;
import com.example.timedeal.domain.user.UserRepository;
import com.example.timedeal.dto.order.request.CreateOrderRequest;
import com.example.timedeal.dto.order.response.CreateOrderResponse;
import com.example.timedeal.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public CreateOrderResponse order(CreateOrderRequest request, String requestHeader) {
        // 회원 찾기
        Long userId = (long) Integer.parseInt(requestHeader.split(" ")[1]);
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("회원을 찾을 수 없습니다. id:" + userId));


        // 상품 찾기
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new IllegalArgumentException("상품을 찾을 수 없습니다. id:" + request.getProductId()));

        // 재고 check and 차감
        product.checkStockQuantity();

        // order 생성
        Order order = Order.createOrder(user, product);

        return orderRepository.save(order).toResponse();
    }
}
