package com.vacance.agreement.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Swagger schema 인식용 클래스
 */
@Getter
@AllArgsConstructor
public class ResponseCodeWrapper {

    private int code;

    private String message;
    public static ResponseCodeWrapper from(ResponseCode message) {
        return new ResponseCodeWrapper(message.getCode(), message.getMessage());
    }
}
