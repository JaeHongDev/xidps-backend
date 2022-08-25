package com.example.sampleauth.domain.auth.service;

import com.example.sampleauth.domain.auth.entity.RefreshToken;
import com.example.sampleauth.domain.auth.repository.RefreshTokenRepository;
import com.example.sampleauth.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final Long refreshTokenDurationMs = 36000L;

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return this.refreshTokenRepository.findByToken(token);
    }

    @Transactional
    public RefreshToken createRefreshToken(String userId) {
        var user = this.userRepository.findById(userId).get();

        var result = this.refreshTokenRepository.findById(userId);

        if(result.isPresent()){ // 기존에 토큰이 저장된 경우
            return result.get().updateNewRefreshToken(
                    UUID.randomUUID().toString(),
                    Instant.now().plusMillis(refreshTokenDurationMs)
            );
        }

        // 토큰 등록이 안되어 있는 경우
        var refreshToken = RefreshToken.builder()
                .user(user)
                .expiryDate(Instant.now().plusMillis(refreshTokenDurationMs))
                .token(UUID.randomUUID().toString()).build();
        user.saveRefreshToken(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            this.refreshTokenRepository.delete(token);
            throw new IllegalArgumentException("토큰 만료");
        }
        return token;
    }

    @Transactional
    public int deleteByUserId(String userId) {
        return this.refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }

}
