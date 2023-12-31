package com.vacance.agreement.api.group;

import com.vacance.agreement.api.group.dto.request.CreateGroupRequest;
import com.vacance.agreement.api.group.dto.request.IntoGroupRequest;
import com.vacance.agreement.api.group.dto.response.GroupIdResponse;
import com.vacance.agreement.api.group.service.GroupService;
import com.vacance.agreement.common.response.ApiResponse;
import com.vacance.agreement.common.response.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "group", description = "Group API")
public class GroupController {

    private final GroupService groupService;

    @Tag(name = "group")
    @Operation(summary = "그룹 생성")
    @PostMapping("/group")
    public ResponseEntity<?> createGroup(@Validated @RequestBody CreateGroupRequest createGroupRequest) {
        GroupIdResponse group = groupService.createGroup(createGroupRequest);

        return new ResponseEntity<>(ApiResponse.ok(ResponseCode.CREATED, group), HttpStatus.CREATED);
    }

    @Tag(name = "group")
    @Operation(summary = "그룹 입장")
    @GetMapping("/group/{groupId}")
    public ResponseEntity<?> checkPw(@PathVariable Long groupId, IntoGroupRequest intoGroupRequest) {
        groupService.checkPw(groupId, intoGroupRequest);

        return new ResponseEntity<>(ApiResponse.ok(ResponseCode.SUCCESS, null), HttpStatus.OK);
    }
}
