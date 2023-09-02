package com.vacance.agreement.api.date;


import com.vacance.agreement.api.date.dto.DateCreateRequestDto;
import com.vacance.agreement.api.date.dto.DatesResponseDto;
import com.vacance.agreement.api.date.service.DateService;
import com.vacance.agreement.api.member.dto.MemberCreateRequestDto;
import com.vacance.agreement.api.member.service.MemberService;
import com.vacance.agreement.common.response.ApiResponse;
import com.vacance.agreement.common.response.ResponseCode;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class DateController {

    private final DateService dateService;

    // 멤버별 날짜 저장
    @PostMapping("/date")
    public ApiResponse<Map<String, Object>> createDate(@RequestBody DateCreateRequestDto request) {
        dateService.createDate(request);
        return ApiResponse.ok(ResponseCode.CREATED, Map.of("memberId", request.getMemberId()));
    }

    // 저장된 멤버 날짜 조회
    @GetMapping("/date")
    public ApiResponse<DatesResponseDto> findDates(@RequestParam Long groupId) {
        return ApiResponse.ok(dateService.findDates(groupId));
    }

}
