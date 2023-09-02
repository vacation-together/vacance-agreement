package com.vacance.agreement.common.advice;

import com.vacance.agreement.common.response.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.NestedRuntimeException;

@Getter
public class CustomException extends NestedRuntimeException {

    private ResponseCode responseCode;
    private Content content;

    public CustomException(ResponseCode code) {
        super(code.getMessage());
        this.responseCode = code;
    }

    @Getter
    @AllArgsConstructor
    private static class Content {
        private String field;
        private String message;
    }
}
