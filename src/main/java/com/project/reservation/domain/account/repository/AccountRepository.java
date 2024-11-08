package com.project.reservation.domain.account.repository;

import com.project.reservation.domain.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
