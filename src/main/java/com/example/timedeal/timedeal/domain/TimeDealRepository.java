package com.example.timedeal.timedeal.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeDealRepository extends JpaRepository<TimeDeal, Long> {
    Optional<TimeDeal> findByProductId(Long productId);
}