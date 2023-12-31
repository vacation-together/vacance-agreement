package com.vacance.agreement.api.date.model;

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
public class Date {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long memberId;
	private String selectedDate;

	@Builder
	public Date(Long memberId, String selectedDate) {
		this.memberId = memberId;
		this.selectedDate = selectedDate;
	}
}
