package com.example.sampledomain.domain.callerId.entity;


import com.example.sampledomain.domain.admin.entity.AdminEntity;
import com.example.sampledomain.domain.company.entity.CompanyEntity;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CallerIdEntity {

    @Id
    @Column(name="caller_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 발신번호 고유 식별번호

    private String number; // 발신번호

    private String manager; // 담당자 명칭

    private String department; // 부서 명칭

    private enum usAbleStatus {
        USABLE,
        UNABLE,
    } // 활성 상태
    //    private CallerIdManagement management; //발신번호 관리 방식

    private String memo; // 메모

    @Embedded
    private CallerIdManagement callerIdManagement;
    // 회사 id
    @ManyToOne
    @JoinColumn(name = "company_abberviation")
    private CompanyEntity      company;


}
