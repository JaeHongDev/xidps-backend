package com.example.sampledomain.domain.admin.entity;

import com.example.sampledomain.domain.admin.entity.id.AdminCompanyId;
import com.example.sampledomain.domain.company.entity.CompanyEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Data
@IdClass(AdminCompanyId.class)
@Entity
public class AdminEntity implements Serializable{

    @Id
    @Column(name="admin_id")
    private String id; // 로그인 아이디
    private String password; // 로그인 비밀번호
    private String name; // 관리자 이름

    @Id
    @ManyToOne
    @JoinColumn(name="company_abberivation")
    private CompanyEntity affiliation; // 소속

    public void setAffiliation(CompanyEntity company){
        this.affiliation = company;
        company.setAdmin(this);
    }
    @Builder
    public AdminEntity(
            String id,
            String password,
            String name, CompanyEntity affiliation) {
        this.id         = id;
        this.password    = password;
        this.name        = name;
        this.affiliation = affiliation;
    }
}
