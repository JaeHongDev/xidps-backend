package com.example.sampleauth.domain.company.repository;

import com.example.sampleauth.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
