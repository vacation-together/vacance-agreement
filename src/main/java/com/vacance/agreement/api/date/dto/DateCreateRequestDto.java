package com.vacance.agreement.api.date.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

@Data
public class DateCreateRequestDto {
	@Schema(description = "멤버 ID")
	private Long memberId;
	@Schema(description = "선택 날짜")
	private List<String> selectedDates;
}
