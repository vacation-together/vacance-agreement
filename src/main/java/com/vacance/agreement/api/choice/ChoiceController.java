package com.vacance.agreement.api.choice;


import com.vacance.agreement.api.choice.dto.ChoiceCreateRequestDto;
import com.vacance.agreement.api.choice.dto.GroupChoiceResponse;
import com.vacance.agreement.api.choice.service.ChoiceService;
import com.vacance.agreement.common.response.ApiResponse;
import com.vacance.agreement.common.response.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "choice", description = "Choice API")
public class ChoiceController {

    private final ChoiceService choiceService;

    // 멤버별 문항 선택 저장
    @Tag(name = "choice")
    @Operation(summary = "멤버별 문항 선택 저장")
    @PostMapping("/choice")
    public ApiResponse<Map<String, Object>> createChoice(@RequestBody ChoiceCreateRequestDto request) {
        choiceService.createChoice(request);
        return ApiResponse.ok(ResponseCode.CREATED, Map.of("memberId", request.getMemberId()));
    }

    @Tag(name = "choice")
    @Operation(summary = "그룹별 선택 조회")
    @GetMapping("/choice/{groupId}")
    public ResponseEntity<?> getTotalChoiceByGroup(@PathVariable long groupId) {
        GroupChoiceResponse groupChoice = choiceService.getGroupChoice(groupId);

        return new ResponseEntity<>(ApiResponse.ok(ResponseCode.SUCCESS, groupChoice), HttpStatus.OK);
    }
}
