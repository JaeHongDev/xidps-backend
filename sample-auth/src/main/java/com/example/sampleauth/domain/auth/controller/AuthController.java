package com.example.sampleauth.domain.auth.controller;


import com.example.sampleauth.domain.auth.dto.JwtResponse;
import com.example.sampleauth.domain.auth.dto.LoginRequest;
import com.example.sampleauth.domain.auth.entity.RefreshToken;
import com.example.sampleauth.domain.auth.service.RefreshTokenService;
import com.example.sampleauth.domain.user.repository.UserRepository;
import com.example.sampleauth.security.JwtUtils;
import com.example.sampleauth.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenService refreshTokenService;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getUserPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);

        RefreshToken refreshToken = this.refreshTokenService
                .createRefreshToken(userDetails.getId());
        return ResponseEntity.ok(JwtResponse.builder()
                .refreshToken(refreshToken.getToken())
                .userId(userDetails.getId())
                .username(userDetails.getUsername())
                .token(jwt).build());
    }

}
