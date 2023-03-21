package com.example.timedeal.service.order;

import com.example.timedeal.dto.order.request.CreateOrderRequest;
import com.example.timedeal.dto.order.response.CreateOrderResponse;
import com.example.timedeal.dto.order.response.GetOrderProductResponse;

import java.util.List;

public interface OrderService {
    CreateOrderResponse order(CreateOrderRequest request, String requestHeader);

    List<GetOrderProductResponse> productList(Long userId);
}