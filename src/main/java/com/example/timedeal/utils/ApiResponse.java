package com.example.timedeal.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private HttpStatus status;
    private T result;

    public static <T> ApiResponse<T> success(T result){
        return new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK, result);
    }
}