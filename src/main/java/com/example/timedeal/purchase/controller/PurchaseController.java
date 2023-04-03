package com.example.timedeal.purchase.controller;

import com.example.timedeal.purchase.dto.request.CreatePurchaseRequest;
import com.example.timedeal.purchase.dto.response.CreatePurchaseResponse;
import com.example.timedeal.purchase.dto.response.GetPurchaseProductResponse;
import com.example.timedeal.purchase.dto.response.GetPurchaseUserResponse;
import com.example.timedeal.purchase.service.PurchaseService;
import com.example.timedeal.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/purchase")
@RestController
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    public ApiResponse<CreatePurchaseResponse> createPurchase(
            @RequestBody CreatePurchaseRequest request
    ){
        return ApiResponse.success(purchaseService.purchase(request));
    }

    @GetMapping("/{userId}/user")
    public ApiResponse<List<GetPurchaseProductResponse>> productListByUser(@PathVariable Long userId){
        return ApiResponse.success(purchaseService.productListByUser(userId));
    }

    @GetMapping("/{productId}/product")
    public ApiResponse< List<GetPurchaseUserResponse>> userListByProduct(@PathVariable Long productId){
        return ApiResponse.success(purchaseService.userListByProduct(productId));
    }
}
