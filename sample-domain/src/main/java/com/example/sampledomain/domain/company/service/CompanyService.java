package com.example.sampledomain.domain.company.service;

import com.example.sampledomain.domain.company.payload.request.CreateCompanyDto;
import com.example.sampledomain.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional
    public void createNewCompany(CreateCompanyDto createCompanyDto) {
        var findResult = this.companyRepository.findById(createCompanyDto.getAbbreviation());

        if(findResult.isPresent()) throw new RuntimeException("이미존재하고 있는 회사 아이디입니다.");

        this.companyRepository.save(createCompanyDto.toEntity());
    }
}
