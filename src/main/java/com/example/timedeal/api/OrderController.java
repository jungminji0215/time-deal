package com.example.timedeal.api;

import com.example.timedeal.dto.order.request.CreateOrderRequest;
import com.example.timedeal.service.order.OrderService;
import com.example.timedeal.utils.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseResult<?> createOrder(
            @RequestBody CreateOrderRequest request,
            @RequestHeader("Authentication") String requestHeader
    ){
        return new ResponseResult<>(orderService.order(request, requestHeader));
    }

    @GetMapping("/orders/{userId}")
    public ResponseResult<?> productList(@PathVariable Long userId){
        return new ResponseResult<>(orderService.productList(userId));
    }

//    @GetMapping("/orders/{productId}")
//    public ResponseResult<?> productList(@PathVariable Long userId){
//        return new ResponseResult<>(orderService.productList(userId));
//    }
}
