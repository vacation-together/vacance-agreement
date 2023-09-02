package com.vacance.agreement.api.group.service;

import com.vacance.agreement.api.group.data.GroupRepository;
import com.vacance.agreement.api.group.dto.request.CreateGroupRequest;
import com.vacance.agreement.api.group.dto.response.GroupIdResponse;
import com.vacance.agreement.api.group.model.Group;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupIdResponse createGroup(CreateGroupRequest createGroupRequest) {
        Group group = groupRepository.save(createGroupRequest.toEntity());

        return GroupIdResponse.toDto(group);
    }
}
