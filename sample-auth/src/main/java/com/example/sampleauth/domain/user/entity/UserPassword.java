package com.example.sampleauth.domain.user.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserPassword {
    @Id
    @Column(name="u_id")
    private String userId;

    @Column(name="u_pr")
    private String userPassword;


    @MapsId
    @OneToOne
    @JoinColumn(name="u_id")
    private Users users;
    @Builder
    public UserPassword(String userPassword, Users users) {
        this.userPassword = userPassword;
        this.users = users;
    }
}

