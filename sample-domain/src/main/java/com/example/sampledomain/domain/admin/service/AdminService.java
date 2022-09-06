package com.example.sampledomain.domain.admin.service;

import com.example.sampledomain.domain.admin.entity.AdminEntity;
import com.example.sampledomain.domain.admin.entity.id.AdminCompanyId;
import com.example.sampledomain.domain.admin.payload.request.CreateAdminDto;
import com.example.sampledomain.domain.admin.repository.AdminRepository;
import com.example.sampledomain.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository   adminRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public void createNewAdmin(CreateAdminDto createAdminDto) {
        var foundAdminAccount = this.adminRepository.findById(createAdminDto.toId());
        var foundCompany      = this.companyRepository.findById(createAdminDto.getCompanyId())
                                                      .orElseThrow(() -> new RuntimeException("등록되지 않은 회사 계정입니다."));

        if (foundAdminAccount.isPresent()) {
            throw new RuntimeException("이미 존재하는 계정입니다");
        }

        var adminAccount = createAdminDto.toEntity();

        adminAccount.setAffiliation(foundCompany);

        this.adminRepository.save(adminAccount);
    }

}
