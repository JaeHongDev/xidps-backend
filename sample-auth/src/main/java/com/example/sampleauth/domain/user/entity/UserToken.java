package com.example.sampleauth.domain.user.entity;

import javax.persistence.*;

@Entity
public class UserToken {
    @Id
    @Column(name="u_id")
    private String id;

    @Column(name="u_token", length = 600)
    private String token;
}
