package com.example.timedeal.exception;

import com.example.timedeal.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class TimeDealControllerAdvice {

    @ExceptionHandler(TimeDealException.class)
    public ResponseEntity<?> handler(TimeDealException e){
        log.error("Error occurs {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(ApiResponse.error(e.getErrorCode().name()));
    }
}
