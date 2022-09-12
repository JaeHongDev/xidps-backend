package com.example.sampledomain.domain.auth.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Entity(name="usr_token")
public class RefreshToken {
    @Id
    private String id;

    @Column(nullable = false , unique = true)
    private String accessToken;

    @Column(nullable = false)
    private Instant expiryDate;

}
