package com.vacance.agreement.api.date.service;

import com.vacance.agreement.api.date.data.DateRepository;
import com.vacance.agreement.api.date.dto.DateCreateRequestDto;
import com.vacance.agreement.api.date.dto.DateResponseDto;
import com.vacance.agreement.api.date.dto.DatesResponseDto;
import com.vacance.agreement.api.date.model.Date;
import com.vacance.agreement.api.group.model.Group;
import com.vacance.agreement.api.member.model.Member;
import com.vacance.agreement.api.member.service.MemberService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("DateService")
@RequiredArgsConstructor
public class DateService {

	private final DateRepository dateRepository;
	private final MemberService memberService;

	public void createDate(DateCreateRequestDto request) {
		for(String selectedDate : request.getSelectedDates()) {
			Date date = Date.builder()
				.memberId(request.getMemberId())
				.selectedDate(selectedDate)
				.build();

			dateRepository.save(date);
		}
	}

	public DatesResponseDto findDates(Long groupId) {
		List<Member> members = memberService.findMemberByGroupId(groupId);
		List<DateResponseDto> response = new ArrayList<>();

		for (Member member : members) {
			List<String> dates = dateRepository.findDatesByMemberId(member.getId());
			response.add(DateResponseDto.builder()
				.memberId(member.getId())
				.selectedDates(dates)
				.build()
			);
		}
		return DatesResponseDto.builder()
			.dateResponseDtoList(response)
			.build();
	}
}
