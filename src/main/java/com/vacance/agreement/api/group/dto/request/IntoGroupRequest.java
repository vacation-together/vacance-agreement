package com.vacance.agreement.api.group.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class IntoGroupRequest {

    @NotBlank
    private String pw;
}
