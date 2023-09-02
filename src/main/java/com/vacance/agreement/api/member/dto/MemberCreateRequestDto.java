package com.vacance.agreement.api.member.dto;

import lombok.Data;

@Data
public class MemberCreateRequestDto {
	private String nickname;
	private Long groupId;
}
