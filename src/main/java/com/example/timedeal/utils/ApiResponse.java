package com.example.timedeal.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private String status;
    private T result;

    public static ApiResponse<Void> error(String errorCode){
        return new ApiResponse<>(errorCode, null);
    }

    public static <T> ApiResponse<T> success(T result){
        return new ApiResponse<>("SUCCESS", result);
    }
}