package com.example.sampledomain.domain.company.repository;

import com.example.sampledomain.domain.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {
}
