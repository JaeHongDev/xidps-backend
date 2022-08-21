package com.example.sampledomain.domain.user.entity;

import javax.persistence.*;

@Entity
@Table(name="usr_tk")
public class UserToken {
    @Id
    @Column(name="usr_num")
    private Long id;

    @Column(name="u_token", length = 600)
    private String token;

    @MapsId
    @OneToOne
    @JoinColumn(name="usr_num")
    private Users user;
}
