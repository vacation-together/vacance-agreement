package com.vacance.agreement.api.choice.dto;

import java.util.List;
import lombok.Data;

@Data
public class ChoiceCreateRequestDto {
	private Long memberId;
	private List<Boolean> choices;
}
