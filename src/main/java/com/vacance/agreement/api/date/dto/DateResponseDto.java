package com.vacance.agreement.api.date.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateResponseDto {
	private Long memberId;
	private List<String> selectedDates;

	@Builder
	public DateResponseDto(Long memberId, List<String> selectedDates) {
		this.memberId = memberId;
		this.selectedDates = selectedDates;
	}
}
