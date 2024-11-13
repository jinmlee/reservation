package com.project.reservation.domain.account.repository;

import com.project.reservation.domain.account.model.Account;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.project.reservation.domain.account.model.QAccount.account;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Account> findActiveById(Long id) {
        return Optional.ofNullable(queryFactory.select(account)
                .from(account)
                .where(account.id.eq(id)
                        .and(account.deletedYn.eq("N")))
                .fetchOne());
    }

    @Override
    public Optional<Account> findByLoginId(String loginId) {
        return Optional.ofNullable(queryFactory.select(account)
                .from(account)
                .where(account.loginId.eq(loginId)
                        .and(account.deletedYn.eq("N")))
                .fetchOne());
    }
}
