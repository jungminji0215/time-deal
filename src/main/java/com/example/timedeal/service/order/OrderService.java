package com.example.timedeal.service.order;

import com.example.timedeal.dto.order.request.CreateOrderRequest;
import com.example.timedeal.dto.order.response.CreateOrderResponse;

public interface OrderService {
    CreateOrderResponse order(CreateOrderRequest request, String requestHeader);
}
