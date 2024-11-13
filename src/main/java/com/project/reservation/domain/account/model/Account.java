package com.project.reservation.domain.account.model;

import com.project.reservation.common.model.BaseEntity;
import com.project.reservation.domain.account.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String loginId;

    private String password;

    private Role role;
}
