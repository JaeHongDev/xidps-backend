package com.example.sampleauth.domain.auth.entity;


import com.example.sampleauth.domain.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Entity(name="usr_token")
public class RefreshToken {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;


    @MapsId
    @JoinColumn(name="u_id")
    @OneToOne
    private Users user;


    @Builder
    public RefreshToken(String id, String token, Instant expiryDate, Users user) {
        this.id = id;
        this.token = token;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    public RefreshToken updateNewRefreshToken(String token, Instant expiryDate) {
        this.token =  token;
        this.expiryDate = expiryDate;
        return this;
    }
}
