package com.example.sampledomain.domain.company.repository;

import com.example.sampledomain.domain.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {

    @Query("SELECT m from CompanyEntity m where m.consonant = :consonant")
    List<CompanyEntity> findByConsonant(String consonant);
}
