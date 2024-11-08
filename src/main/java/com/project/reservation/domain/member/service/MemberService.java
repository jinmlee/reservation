package com.project.reservation.domain.member.service;

import com.project.reservation.domain.account.repository.AccountRepository;
import com.project.reservation.domain.member.dto.MemberJoinDto;
import com.project.reservation.domain.member.model.Member;
import com.project.reservation.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AccountRepository accountRepository;

    public void joinMember(MemberJoinDto memberJoinDto) {

        Member member = Member.builder().build();

        memberRepository.save(member);
    }
}
