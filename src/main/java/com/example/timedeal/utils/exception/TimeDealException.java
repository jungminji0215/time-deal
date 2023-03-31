package com.example.timedeal.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TimeDealException extends RuntimeException{
    private ErrorCode errorCode;

    private String message;

    @Override
    public String getMessage(){
        if(message == null){
            return errorCode.getErrorMessage();
        }
        return String.format("%s. %s", errorCode.getErrorMessage(), message);
    }
}
