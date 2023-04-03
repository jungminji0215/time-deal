package com.example.timedeal.purchase.service.impl;

import com.example.timedeal.product.domain.Product;
import com.example.timedeal.product.domain.ProductRepository;
import com.example.timedeal.purchase.domain.Purchase;
import com.example.timedeal.purchase.domain.PurchaseRepository;
import com.example.timedeal.purchase.dto.request.CreatePurchaseRequest;
import com.example.timedeal.purchase.dto.response.CreatePurchaseResponse;
import com.example.timedeal.purchase.dto.response.GetPurchaseProductResponse;
import com.example.timedeal.purchase.dto.response.GetPurchaseUserResponse;
import com.example.timedeal.purchase.service.PurchaseService;
import com.example.timedeal.timedeal.domain.TimeDeal;
import com.example.timedeal.timedeal.domain.TimeDealRepository;
import com.example.timedeal.user.domain.User;
import com.example.timedeal.user.domain.UserRepository;
import com.example.timedeal.utils.exception.ErrorCode;
import com.example.timedeal.utils.exception.TimeDealException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final TimeDealRepository timeDealRepository;

    @Override
    @Transactional
    public CreatePurchaseResponse purchase(CreatePurchaseRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new TimeDealException(ErrorCode.USER_NOT_FOUNDED, "유저 아이디 : " + request.getUserId()));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new TimeDealException(ErrorCode.PRODUCT_NOT_FOUND, "상품 아이디 : " + request.getProductId()));

        TimeDeal timeDeal = timeDealRepository.findByProductId(request.getProductId())
                .orElseThrow(()-> new TimeDealException(ErrorCode.TIME_DEAL_NOT_FOUND, "진행중인 타임딜이 상품이 아닙니다."));

        Purchase purchase = Purchase.of(user, product, timeDeal, request.getCnt());

        return CreatePurchaseResponse.toCreateResponse(purchaseRepository.save(purchase));
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetPurchaseProductResponse> productListByUser(Long userId) {
        List<GetPurchaseProductResponse> result = purchaseRepository.findAllByUserId(userId).stream()
                .map(purchase -> new GetPurchaseProductResponse(purchase.getProduct().getId(), purchase.getProduct().getName()))
                .collect(Collectors.toList());

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetPurchaseUserResponse> userListByProduct(Long productId) {
        List<GetPurchaseUserResponse> result = purchaseRepository.findAllByProductId(productId).stream()
                .map(purchase -> new GetPurchaseUserResponse(purchase.getUser().getId(), purchase.getUser().getName()))
                .collect(Collectors.toList());

        return result;
    }
}
