package com.example.sampledomain.domain.company.payload.request;

import com.example.sampledomain.domain.company.entity.CompanyEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateCompanyDto {
    private String abbreviation;
    private String name;
    private String consonant;


    @Builder
    public CreateCompanyDto(String abbreviation, String name, String consonant) {
        this.abbreviation = abbreviation;
        this.name         = name;
        this.consonant    = consonant;
    }

    public CompanyEntity toEntity() {
        return CompanyEntity.builder()
                            .abbreviation(this.abbreviation)
                            .createdAt(LocalDateTime.now())
                            .consonant(this.consonant)
                            .name(this.name)
                            .build();
    }
}
