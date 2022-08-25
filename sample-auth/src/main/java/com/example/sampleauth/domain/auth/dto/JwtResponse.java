package com.example.sampleauth.domain.auth.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type="Bearer";
    private String refreshToken;

    private String userId;
    private String username;


    @Builder
    public JwtResponse(String token, String refreshToken, String userId, String username) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.userId = userId;
        this.username = username;
    }
}
