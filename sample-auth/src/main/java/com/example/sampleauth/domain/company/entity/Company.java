package com.example.sampleauth.domain.company.entity;

import com.example.sampleauth.domain.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Users> users = new ArrayList<>();

    @Builder
    public Company(String name) {
        this.name = name;
    }
    public void registerUser(Users user) {
        this.users.add(user);
    }
}
