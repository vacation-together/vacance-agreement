package com.vacance.agreement.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(200, "API 요청 성공"),
    CREATED(201, "CREATED"),
    UPDATED(202, "UPDATED"),
    DELETED(203, "DELETED"),

    GROUP_NOT_FOUND(404, "해당 모임을 찾을 수 없습니다."),
    GROUP_PW_NOT_EQ(400, "모임의 비밀번호가 일치하지 않습니다.")
    ;

    private final int code;
    private final String message;
}
