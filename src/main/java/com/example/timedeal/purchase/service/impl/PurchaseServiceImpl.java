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
import com.example.timedeal.user.domain.User;
import com.example.timedeal.user.domain.UserRepository;
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

    @Override
    @Transactional
    public CreatePurchaseResponse purchase(CreatePurchaseRequest request, String requestHeader) {
        Long userId = (long) Integer.parseInt(requestHeader.split(" ")[1]);

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("회원을 찾을 수 없습니다. id:" + userId));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new IllegalArgumentException("상품을 찾을 수 없습니다. id:" + request.getProductId()));

        product.checkTime();

        product.checkStockQuantity();

        Purchase purchase = Purchase.createPurchase(user, product);

        return purchaseRepository.save(purchase).toResponse();
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
