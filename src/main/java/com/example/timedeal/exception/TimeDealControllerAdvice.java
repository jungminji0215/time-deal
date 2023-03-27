package com.example.timedeal.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class TimeDealControllerAdvice {

    @ExceptionHandler(TimeDealException.class)
    public ResponseEntity<?> handler(TimeDealException e){
        log.error("🚫 Error occurs!! {}", e.getMessage());

        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ErrorResponse.error(
                        e.getErrorCode().getCode(),
                        e.getErrorCode().name(),
                        e.getErrorCode().getErrorMessage())
                );
    }
}
