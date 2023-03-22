package com.example.timedeal.domain.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findAllByUserId(Long userId);

    List<Purchase> findAllByProductId(Long productId);
}