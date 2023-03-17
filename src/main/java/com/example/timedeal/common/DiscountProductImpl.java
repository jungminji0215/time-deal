package com.example.timedeal.common;

import org.springframework.stereotype.Service;

@Service
public class DiscountProductImpl implements DiscountProductService{
    @Override
    public int calculateProductSale(int price, int discount) {
        return price - discount;
    }
}
