package com.example.sampledomain.domain.company.entity;

import com.example.sampledomain.domain.admin.entity.AdminEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class CompanyEntity {
    @Id
    @Column(name="company_abberviation")
    private String abbreviation; // 회사 밑 학교 약어
    private String name; //회사명칭
    private String consonant;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "affiliation", fetch = FetchType.LAZY)
    private List<AdminEntity> admins = new ArrayList<AdminEntity>();


    @Builder
    public CompanyEntity(
            String abbreviation,
            String name,
            String consonant, LocalDateTime createdAt,
            List<AdminEntity> admins) {
        this.abbreviation = abbreviation;
        this.name         = name;
        this.consonant    = consonant;
        this.createdAt    = createdAt;
        this.admins       = admins;
    }

    public void setAdmin(AdminEntity adminEntity) {
        if(this.admins == null) {
            this.admins = new ArrayList<>();
        }
        this.admins.add(adminEntity);
    }
}
