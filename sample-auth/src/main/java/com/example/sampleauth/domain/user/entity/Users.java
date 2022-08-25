package com.example.sampleauth.domain.user.entity;

import com.example.sampleauth.domain.auth.entity.RefreshToken;
import com.example.sampleauth.domain.company.entity.Company;
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

    @OneToOne(mappedBy = "users", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private UserPassword userPassword;


    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private RefreshToken userToken;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    @JoinColumn(name="company_id")
    private Company company;

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

    public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
        this.userToken = refreshToken;
        return refreshToken;
    }

    public void registerCompany(Company company) {
        this.company = company;
        this.company.registerUser(this);

    }
}
