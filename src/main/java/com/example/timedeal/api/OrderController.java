package com.example.timedeal.api;

import com.example.timedeal.dto.order.request.CreateOrderRequest;
import com.example.timedeal.dto.order.response.CreateOrderResponse;
import com.example.timedeal.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public CreateOrderResponse createOrder(
            @RequestBody CreateOrderRequest request,
            @RequestHeader("Authentication") String requestHeader
    ){
        return orderService.order(request, requestHeader);
    }
}
