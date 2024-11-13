package com.project.reservation.domain.account.repository;

import com.project.reservation.domain.account.model.Account;

import java.util.Optional;

public interface AccountRepositoryCustom {

    Optional<Account> findActiveById(Long id);

    Optional<Account> findByLoginId(String loginId);
}
