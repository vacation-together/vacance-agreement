package com.vacance.agreement.api.member;


import com.vacance.agreement.api.member.dto.MemberCreateRequestDto;
import com.vacance.agreement.api.member.service.MemberService;
import com.vacance.agreement.common.response.ApiResponse;
import com.vacance.agreement.common.response.ResponseCode;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
