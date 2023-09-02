package com.vacance.agreement.common.advice;

import com.vacance.agreement.common.response.ApiResponse;
import com.vacance.agreement.common.response.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    protected ResponseEntity<?> handleCustomException(CustomException exception) {
        ResponseCode responseCode = exception.getResponseCode();
        return new ResponseEntity<>(ApiResponse.ok(responseCode, exception.getContent()), HttpStatus.valueOf(responseCode.getCode()));
    }
}
