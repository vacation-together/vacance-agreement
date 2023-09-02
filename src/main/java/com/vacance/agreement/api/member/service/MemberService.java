package com.vacance.agreement.api.member.service;

import com.vacance.agreement.api.member.data.MemberRepository;
import com.vacance.agreement.api.member.dto.MemberCreateRequestDto;
import com.vacance.agreement.api.member.model.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MemberService")
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long createMember(MemberCreateRequestDto request) {
        Member member = memberRepository.save(Member.builder()
                .nickname(request.getNickname())
                .groupId(request.getGroupId())
                .build());

        return member.getId();
    }

    public List<Member> findMemberByGroupId(Long groupId) {
        return memberRepository.findByGroupId(groupId);
    }
}
