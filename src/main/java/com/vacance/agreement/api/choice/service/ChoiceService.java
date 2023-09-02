package com.vacance.agreement.api.choice.service;

import com.vacance.agreement.api.choice.data.ChoiceRepository;
import com.vacance.agreement.api.choice.dto.ChoiceCreateRequestDto;
import com.vacance.agreement.api.choice.model.Choice;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ChoiceService")
@RequiredArgsConstructor
public class ChoiceService {

	private final ChoiceRepository choiceRepository;

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
}
