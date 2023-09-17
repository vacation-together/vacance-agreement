package com.vacance.agreement.api.member;


import com.vacance.agreement.api.member.dto.MemberCreateRequestDto;
import com.vacance.agreement.api.member.service.MemberService;
import com.vacance.agreement.common.response.ApiResponse;
import com.vacance.agreement.common.response.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "member", description = "Member API")
public class MemberController {

    private final MemberService memberService;

    // 멤버 등록
    @Tag(name = "member")
    @Operation(summary = "멤버 등록")
    @PostMapping("/member")
    public ApiResponse<Map<String, Object>> createMember(@RequestBody MemberCreateRequestDto request) {
        Long memberId = memberService.createMember(request);
        return ApiResponse.ok(ResponseCode.CREATED, Map.of("memberId", memberId));
    }

}
