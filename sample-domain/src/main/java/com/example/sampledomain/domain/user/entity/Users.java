package com.example.sampledomain.domain.user.entity;

import javax.persistence.*;

@Entity
@Table(name="xid_mbs")
public class Users {
    @Id
    @GeneratedValue
    @Column(name="usr_num")
    private Long number;

    @Column(name="u_id" , unique = true)
    private String id;

    @Column(name="jwt", length = 1024)
    private String jwt;

    @OneToOne(mappedBy = "user")
    private UserPassword userPassword;

    @OneToOne(mappedBy = "user")
    private UserToken userToken;
}
