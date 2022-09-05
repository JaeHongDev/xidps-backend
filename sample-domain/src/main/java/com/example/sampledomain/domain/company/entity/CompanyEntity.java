package com.example.sampledomain.domain.company.entity;

import com.example.sampledomain.domain.admin.entity.AdminEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class CompanyEntity {
    @Id
    private String abbreviation; // 회사 밑 학교 약어
    private String name; //회사명칭

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "affiliation")
    private List<AdminEntity> admins;


    @Builder
    public CompanyEntity(
            String abbreviation,
            String name,
            LocalDateTime createdAt,
            List<AdminEntity> admins) {
        this.abbreviation = abbreviation;
        this.name         = name;
        this.createdAt    = createdAt;
        this.admins       = admins;
    }
}
