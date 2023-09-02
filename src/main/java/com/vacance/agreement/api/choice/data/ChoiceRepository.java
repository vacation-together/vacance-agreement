package com.vacance.agreement.api.choice.data;

import com.vacance.agreement.api.choice.model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    @Query("SELECT c FROM Choice c " +
            "WHERE c.memberId in (:memberIdList) " +
            "ORDER BY c.memberId ASC, c.choiceNo ASC")
    List<Choice> findAllByMemberId(List<Long> memberIdList);
}
