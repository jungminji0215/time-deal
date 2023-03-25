package com.example.timedeal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "[아이디가 중복되었습니다]"),
    NOT_EXISTS_USER(HttpStatus.BAD_REQUEST , "[존재하지 않는 유저입니다]");
    // TODO 상품 오류 추가

    private HttpStatus status;

    private String message;
}
