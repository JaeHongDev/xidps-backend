package com.example.sampleauth.domain.user.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue
    @Column(name="usr_num")
    private Long number;

    @Column(name="u_id", unique = true)
    private String id;

    @Column(name="jwt", length = 1024)
    private String jwt;

    @OneToOne()
    private UserPassword userPassword;

    @OneToOne()
    private UserToken userToken;
}
