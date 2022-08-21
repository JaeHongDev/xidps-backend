package com.example.sampledomain.domain.user.entity;


import javax.persistence.*;

@Entity
@Table(name="l_usr_inf")
public class UserPassword {
    @Id
    @Column(name = "usr_num", unique = true)
    private Long userId;

    @Column(name="u_pr")
    private String userPassword;

    @MapsId
    @OneToOne
    @JoinColumn(name="usr_num")
    private Users user;
}

