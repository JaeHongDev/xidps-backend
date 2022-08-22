package com.example.sampleauth.domain.user.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class UserPassword {
    @Id
    @Column(name = "u_id")
    private String userId;

    @Column(name="u_pr")
    private String userPassword;

}

