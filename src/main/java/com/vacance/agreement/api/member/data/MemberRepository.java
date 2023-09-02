package com.vacance.agreement.api.member.data;

import com.vacance.agreement.api.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
