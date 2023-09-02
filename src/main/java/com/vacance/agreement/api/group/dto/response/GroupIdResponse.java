package com.vacance.agreement.api.group.dto.response;

import com.vacance.agreement.api.group.model.Group;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GroupIdResponse {

    private long id;

    public static GroupIdResponse toDto(Group group) {
        return GroupIdResponse.builder()
                .id(group.getId())
                .build();
    }
}
