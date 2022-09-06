package com.example.sampledomain.domain.admin.repository;

import com.example.sampledomain.domain.admin.entity.AdminEntity;
import com.example.sampledomain.domain.admin.entity.id.AdminCompanyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, AdminCompanyId> {
}
