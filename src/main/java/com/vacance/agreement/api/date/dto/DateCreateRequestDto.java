package com.vacance.agreement.api.date.dto;

import java.util.List;
import lombok.Data;

@Data
public class DateCreateRequestDto {
	private Long memberId;
	private List<String> selectedDates;
}
