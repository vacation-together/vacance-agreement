package com.vacance.agreement.api.member.service;

import com.vacance.agreement.api.member.data.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("MemberService")
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

}
