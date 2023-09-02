package com.vacance.agreement.api.group.dto.request;

import com.vacance.agreement.api.group.model.Group;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateGroupRequest {

    @NotBlank(message = "공백은 입력할 수 없습니다.")
    private String title;

    @NotBlank(message = "공백은 입력할 수 없습니다.")
    private String pw;

    public Group toEntity() {
        return Group.builder()
                .pw(pw)
                .title(title)
                .build();
    }
}
