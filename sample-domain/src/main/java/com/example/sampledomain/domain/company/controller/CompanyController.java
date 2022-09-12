package com.example.sampledomain.domain.company.controller;

import com.example.sampledomain.domain.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/company")
@RestController
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/abbreviation/{consonant}")
    public ResponseEntity<?> findByConsonant(@PathVariable String consonant){
        return ResponseEntity.ok().body(this.companyService.findByConsonant(consonant));
    }
}
