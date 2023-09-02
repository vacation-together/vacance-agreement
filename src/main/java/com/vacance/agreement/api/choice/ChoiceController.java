package com.vacance.agreement.api.choice;


import com.vacance.agreement.api.choice.dto.ChoiceCreateRequestDto;
import com.vacance.agreement.api.choice.service.ChoiceService;
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
public class ChoiceController {

    private final ChoiceService choiceService;

    // 멤버별 문항 선택 저장
    @PostMapping("/date")
    public ApiResponse<Map<String, Object>> createChoice(@RequestBody ChoiceCreateRequestDto request) {
        choiceService.createChoice(request);
        return ApiResponse.ok(ResponseCode.CREATED, Map.of("memberId", request.getMemberId()));
    }

}
