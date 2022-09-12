package com.example.sampledomain;

import com.example.sampledomain.domain.company.payload.request.CreateCompanyDto;
import com.example.sampledomain.domain.company.repository.CompanyRepository;
import com.example.sampledomain.domain.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@RequiredArgsConstructor
@SpringBootApplication
public class SampleDomainApplication implements CommandLineRunner {
    private final CompanyRepository companyRepository;
    private final CompanyService companyService;
    public static void main(String[] args) {
        SpringApplication.run(SampleDomainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        this.companyService.createNewCompany(CreateCompanyDto.builder().abbreviation("xidsys_c").name("xid").consonant("ㅅ").build());
    }
}
