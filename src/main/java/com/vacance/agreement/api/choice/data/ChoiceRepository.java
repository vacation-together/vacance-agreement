package com.vacance.agreement.api.choice.data;

import com.vacance.agreement.api.choice.model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {

}
