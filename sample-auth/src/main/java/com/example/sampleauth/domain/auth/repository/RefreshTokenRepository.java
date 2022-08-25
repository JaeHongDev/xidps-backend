package com.example.sampleauth.domain.auth.repository;

import com.example.sampleauth.domain.auth.entity.RefreshToken;
import com.example.sampleauth.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(Users user);
}
