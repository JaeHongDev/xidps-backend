package com.example.sampledomain.domain.company.service;

import com.example.sampledomain.domain.company.payload.request.CreateCompanyDto;
import com.example.sampledomain.domain.company.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    @Test
    public void 새로운회사가정상적으로만들어진다(){

        String newCompanyId = "xid_c";
        this.companyService.createNewCompany(CreateCompanyDto.builder()
                                                     .abbreviation(newCompanyId)
                                                     .name("씨드시스템").build());

        var createdNewCompany = this.companyRepository.findById(newCompanyId).orElseThrow();

        assertThat(createdNewCompany.getAbbreviation()).isEqualTo(newCompanyId);
        assertThat(createdNewCompany.getName()).isEqualTo("씨드시스템");
    }

    @Transactional
    @Test
    public void 중복된회사가만들어져에러가발생합니다(){
        String newCompanyId = "xid_c";

        assertThatThrownBy(()->{
            this.companyService.createNewCompany(CreateCompanyDto.builder()
                                                                 .abbreviation(newCompanyId)
                                                                 .name("씨드시스템").build());
            this.companyService.createNewCompany(CreateCompanyDto.builder()
                                                                 .abbreviation(newCompanyId)
                                                                 .name("씨드시스템").build());
        }, "이미존재하고 있는 회사 아이디입니다.");
    }



}