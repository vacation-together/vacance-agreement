package com.vacance.agreement.api.choice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Choice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long memberId;
	private Integer choiceNo;
	private Boolean choice;

	@Builder
	public Choice(Long memberId, Integer choiceNo, Boolean choice) {
		this.memberId = memberId;
		this.choiceNo = choiceNo;
		this.choice = choice;
	}
}
