package com.project.reservation.security.api;

import com.project.reservation.domain.account.service.AccountService;
import com.project.reservation.security.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final AccountService accountService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto) {
        accountService.saveAccount(joinDto);
        return ResponseEntity.ok("Successfully joined");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Successfully logged in");
    }
}
