package com.example.timedeal.api;

import com.example.timedeal.dto.order.request.CreateOrderRequest;
import com.example.timedeal.dto.order.response.CreateOrderResponse;
import com.example.timedeal.service.order.OrderService;
import com.example.timedeal.utils.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/order/product/{productId}")
    public ResponseResult listProduct(){
        return orderService.listProduct();
    }
}
