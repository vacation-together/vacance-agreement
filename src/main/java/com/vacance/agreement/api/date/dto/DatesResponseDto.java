package com.vacance.agreement.api.date.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DatesResponseDto {
	private List<DateResponseDto> dateResponseDtoList;

	@Builder
	public DatesResponseDto(List<DateResponseDto> dateResponseDtoList) {
		this.dateResponseDtoList = dateResponseDtoList;
	}
}
