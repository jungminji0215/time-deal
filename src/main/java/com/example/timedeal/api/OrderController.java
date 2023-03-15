package com.example.timedeal.api;

import com.example.timedeal.dto.order.request.CreateOrderRequest;
import com.example.timedeal.service.order.OrderService;
import com.example.timedeal.utils.ResponseResult;
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
    public ResponseResult<?> createOrder(
            @RequestBody CreateOrderRequest request,
            @RequestHeader("Authentication") String requestHeader
    ){
        return new ResponseResult<>(orderService.order(request, requestHeader));
    }
}
