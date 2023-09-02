package com.vacance.agreement.api.choice.service;

import com.vacance.agreement.api.choice.data.ChoiceRepository;
import com.vacance.agreement.api.choice.dto.ChoiceCreateRequestDto;
import com.vacance.agreement.api.choice.dto.GroupChoiceResponse;
import com.vacance.agreement.api.choice.model.Choice;
import java.util.List;
import java.util.stream.Collectors;

import com.vacance.agreement.api.group.model.Group;
import com.vacance.agreement.api.group.service.GroupService;
import com.vacance.agreement.api.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ChoiceService")
@RequiredArgsConstructor
public class ChoiceService {

	private final ChoiceRepository choiceRepository;
	private final GroupService groupService;

	public void createChoice(ChoiceCreateRequestDto request) {
		List<Boolean> choices = request.getChoices();

		for (int i = 0; i < choices.size(); i++) {
			Choice choice = Choice.builder()
				.memberId(request.getMemberId())
				.choiceNo(i)
				.choice(choices.get(i))
				.build();
			choiceRepository.save(choice);
		}
	}

	public GroupChoiceResponse getGroupChoice(long groupId) {
		Group group = groupService.getGroupWithMembers(groupId);
		List<Member> memberList = group.getMemberList();

		List<Long> memberIdList = memberList.stream().map(Member::getId).collect(Collectors.toList());
		List<Choice> choiceList = choiceRepository.findAllByMemberId(memberIdList);

		return GroupChoiceResponse.toDto(memberList, choiceList);
	}
}
