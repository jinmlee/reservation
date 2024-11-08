package com.project.reservation.domain.member.api;

import com.project.reservation.domain.member.dto.MemberJoinDto;
import com.project.reservation.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/member")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @PostMapping
    public void createMember(@RequestBody MemberJoinDto memberJoinDto) {

    }
}
