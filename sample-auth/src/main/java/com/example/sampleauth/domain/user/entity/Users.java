package com.example.sampleauth.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @Column(name="u_id")
    private String id;

    @Column(name="jwt", length = 1024)
    private String jwt;

    private String name;

    @OneToOne(mappedBy = "users", cascade = CascadeType.PERSIST)
    private UserPassword userPassword;


/*
    @OneToOne(mappedBy = "users", fetch = FetchType.LAZY)
    private UserToken userToken;
*/

    @Builder
    public Users(String id, String jwt, UserPassword userPassword) {
        this.id = id;
        this.jwt = jwt;
        this.userPassword = userPassword;

    }

    public void createPassword(String password){
        this.userPassword = UserPassword.builder().users(this).userPassword(password).build();
    }

    public void changeName(String aa) {
       this.name = aa;
    }
}
