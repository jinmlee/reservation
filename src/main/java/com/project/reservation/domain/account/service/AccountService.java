package com.project.reservation.domain.account.service;

import com.project.reservation.domain.account.model.Account;
import com.project.reservation.domain.account.repository.AccountRepository;
import com.project.reservation.domain.member.model.Member;
import com.project.reservation.domain.member.repository.MemberRepository;
import com.project.reservation.security.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveAccount(JoinDto joinDto) {

        Account account = accountRepository.save(Account.builder()
                        .loginId(joinDto.getLoginId())
                        .password(passwordEncoder.encode(joinDto.getPassword()))
                        .build());

        memberRepository.save(Member.builder()
                        .name(joinDto.getName())
                        .account(account)
                        .build());
    }
}
