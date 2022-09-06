package com.example.sampledomain.domain.admin.service;

import com.example.sampledomain.domain.admin.payload.request.CreateAdminDto;
import com.example.sampledomain.domain.admin.repository.AdminRepository;
import com.example.sampledomain.domain.company.entity.CompanyEntity;
import com.example.sampledomain.domain.company.payload.request.CreateCompanyDto;
import com.example.sampledomain.domain.company.repository.CompanyRepository;
import com.example.sampledomain.domain.company.service.CompanyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepository companyRepository;

    private CompanyEntity company;

    @BeforeEach
    private void setUp(){
        this.companyService.createNewCompany(CreateCompanyDto.builder()
                                                     .abbreviation("xid_c")
                                                     .name("씨드시스템")
                                                     .build());
        this.company = this.companyRepository.findById("xid_c").get();
    }

    @AfterEach
    private void tearDown(){
        this.company = null;
    }

    @Test
    @Transactional
    public void 관리자계정이정상적으로생성됩니다() {

        var createAdminDto = CreateAdminDto.builder()
                                           .id("xidsys")
                                           .name("name")
                                           .password("password")
                                           .companyId("xid_c")
                                           .build();

        this.adminService.createNewAdmin(createAdminDto);

    }


}