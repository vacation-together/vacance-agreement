package com.vacance.agreement.api.group.service;

import com.vacance.agreement.api.group.data.GroupRepository;
import com.vacance.agreement.api.group.dto.request.CreateGroupRequest;
import com.vacance.agreement.api.group.dto.request.IntoGroupRequest;
import com.vacance.agreement.api.group.dto.response.GroupIdResponse;
import com.vacance.agreement.api.group.model.Group;
import com.vacance.agreement.common.advice.CustomException;
import com.vacance.agreement.common.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    @Transactional
    public GroupIdResponse createGroup(CreateGroupRequest createGroupRequest) {
        Group group = groupRepository.save(createGroupRequest.toEntity());

        return GroupIdResponse.toDto(group);
    }

    @Transactional(readOnly = true)
    public void checkPw(Long groupId, IntoGroupRequest intoGroupRequest) {
        Group group = getGroup(groupId);
        group.checkPw(intoGroupRequest.getPw());
    }

    private Group getGroup(Long groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new CustomException(ResponseCode.GROUP_NOT_FOUND));
    }
}
