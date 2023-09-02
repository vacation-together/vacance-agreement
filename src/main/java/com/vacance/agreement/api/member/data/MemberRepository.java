package com.vacance.agreement.api.member.data;

import com.vacance.agreement.api.member.model.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByGroupId(Long groupId);
}
