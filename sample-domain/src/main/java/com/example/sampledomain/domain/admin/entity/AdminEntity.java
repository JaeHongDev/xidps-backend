package com.example.sampledomain.domain.admin.entity;

import com.example.sampledomain.domain.company.entity.CompanyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid; // 관리자 고유 식별 번호

    private String id; // 로그인 아이디
    private String password; // 로그인 비밀번호
    private String name; // 관리자 이름

    @MapsId
    @ManyToOne
    private CompanyEntity affiliation; // 소속


    @Builder
    public AdminEntity(
            Long uuid,
            String id,
            String password,
            String name, CompanyEntity affiliation) {
        this.uuid        = uuid;
        this.id          = id;
        this.password    = password;
        this.name        = name;
        this.affiliation = affiliation;
    }
}
