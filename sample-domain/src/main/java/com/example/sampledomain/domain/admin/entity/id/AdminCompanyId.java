package com.example.sampledomain.domain.admin.entity.id;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class AdminCompanyId implements Serializable {
    private String id;
    private String affiliation;


    @Builder
    public AdminCompanyId(String id, String affiliation) {
        this.id          = id;
        this.affiliation = affiliation;
    }
}
