package com.project.reservation.security.service;

import com.project.reservation.domain.account.model.Account;
import com.project.reservation.domain.account.repository.AccountRepository;
import com.project.reservation.domain.account.service.AccountService;
import com.project.reservation.security.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByLoginId(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new CustomUserDetails(account);
    }
}
