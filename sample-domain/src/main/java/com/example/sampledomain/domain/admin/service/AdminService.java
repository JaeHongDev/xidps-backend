package com.example.sampledomain.domain.admin.service;

import com.example.sampledomain.domain.admin.entity.AdminEntity;
import com.example.sampledomain.domain.admin.payload.request.CreateAdminDto;
import com.example.sampledomain.domain.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;


    @Transactional
    public void createNewAdmin(CreateAdminDto createAdminDto){

    }

}
