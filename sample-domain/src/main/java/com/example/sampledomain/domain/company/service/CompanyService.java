package com.example.sampledomain.domain.company.service;

import com.example.sampledomain.domain.company.entity.CompanyEntity;
import com.example.sampledomain.domain.company.payload.request.CreateCompanyDto;
import com.example.sampledomain.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<CompanyEntity> findByConsonant(String consonant) {
        return this.companyRepository.findByConsonant(consonant);
    }
}
