package com.example.timedeal.utils.stock;

import com.example.timedeal.product.domain.Product;

public class CalculateStock {
    public static void decreaseStock(Product product){
        product.getStockQuantity();
    }
}


//        List<Order> orders = orderRepository.findAllByUserId(userId);
//
//        List<GetOrderProductResponse> result = new ArrayList<>();
//
//        for(Order x: orders){
//            GetOrderProductResponse test = new GetOrderProductResponse(x.getProduct().getId(), x.getProduct().getName());
//            result.add(test);
//        }