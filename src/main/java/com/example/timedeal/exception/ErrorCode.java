package com.example.timedeal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "아이디가 중복되었습니다"),
    USER_NOT_FOUNDED(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND , "존재하지 않는 유저입니다"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND , "존재하지 않는 상품입니다");

    private int code;

    private HttpStatus status;

    private String errorMessage;
}
