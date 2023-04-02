package com.example.timedeal.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "아이디가 중복되었습니다"),
    USER_NOT_FOUNDED(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND , "존재하지 않는 유저입니다"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND , "존재하지 않는 상품입니다"),
    TIME_DEAL_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND , "존재하지 않는 타임딜입니다"),

    // TODO HttpStatus 확인
    AFTER_TIME_DEAL(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST , "타임딜 종료일이 지났습니다"),
    BEFORE_TIME_DEAL(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST , "타임딜 시작전 입니다"),
    SOLD_OUT(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST , "재고가 없습니다.");

    private int code;

    private HttpStatus status;

    private String errorMessage;
}
