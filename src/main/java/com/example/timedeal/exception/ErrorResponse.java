package com.example.timedeal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int code;

    private String status;

    private String message;

    public static ErrorResponse error(int code, String errorCode, String message){
        return new ErrorResponse(code, errorCode, message);
    }
}
