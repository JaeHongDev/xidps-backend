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

    private enum callerIdGovernment {
        FILE_AUTHENTICATION, // 파일인증방식
        API_AUTHENTICATION // api 인증방식
    }

    private String filePath; // 인증 파일 경로
    private String fileSize; // 인증 파일 크기

    private String apiId; // api 인증 아이디
    private LocalDateTime authenticatedDate; // api 인증일

    private String writer; // 데이터 작성자
    private LocalDateTime createdAt; // 데이터 생성일
    private LocalDateTime updatedAt; // 데이터 저장일

    // 회사 id
    @ManyToOne
    @JoinColumn(name = "company_abberviation")
    private CompanyEntity company;

}
