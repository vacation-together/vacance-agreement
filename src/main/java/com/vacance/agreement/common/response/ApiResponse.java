package com.vacance.agreement.common.response;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ApiResponse<T> {

    private final ResponseCodeWrapper message;
    private final T result;

    private ApiResponse(ResponseCode message, T result) {
        this.message = ResponseCodeWrapper.from(message);
        this.result = result;
    }

    public static <T> ApiResponse<T> ok(@Nullable T result) {
        return new ApiResponse<T>(ResponseCode.SUCCESS, result);
    }

    public static <T> ApiResponse<T> ok(ResponseCode code) {
        return new ApiResponse<T>(code, null);
    }

    public static <T> ApiResponse<T> ok(ResponseCode code, @Nullable T result) {
        return new ApiResponse<T>(code, result);
    }

    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<T>(ResponseCode.SUCCESS, null);
    }
}
