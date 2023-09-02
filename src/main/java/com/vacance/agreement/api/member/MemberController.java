package com.vacance.agreement.api.member;


import com.vacance.agreement.api.member.dto.MemberCreateRequestDto;
import com.vacance.agreement.api.member.service.MemberService;
import com.vacance.agreement.common.response.ApiResponse;
import com.vacance.agreement.common.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // 멤버 등록
    @PostMapping("/member")
    public ApiResponse<Map<String, Object>> createMember(@RequestBody MemberCreateRequestDto request) {
        Long memberId = memberService.createMember(request);
        return ApiResponse.ok(ResponseCode.CREATED, Map.of("memberId", memberId));
    }

}
