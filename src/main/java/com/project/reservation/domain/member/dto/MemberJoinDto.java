package com.project.reservation.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinDto {

    private String loginId;

    private String password;

    private String name;
}
