package com.example.timedeal.purchase.service;


import com.example.timedeal.purchase.dto.request.CreatePurchaseRequest;
import com.example.timedeal.purchase.dto.response.CreatePurchaseResponse;
import com.example.timedeal.purchase.dto.response.GetPurchaseProductResponse;
import com.example.timedeal.purchase.dto.response.GetPurchaseUserResponse;

import java.util.List;

public interface PurchaseService {
    CreatePurchaseResponse purchase(CreatePurchaseRequest request, String requestHeader);

    // 유저별 상품 리스트
    List<GetPurchaseProductResponse> productListByUser(Long userId);

    // 상품별 유저 리스트
    List<GetPurchaseUserResponse> userListByProduct(Long productId);
}