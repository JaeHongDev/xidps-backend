package com.example.sampledomain.domain.admin.payload.request;


import com.example.sampledomain.domain.admin.entity.AdminEntity;
import com.example.sampledomain.domain.admin.entity.id.AdminCompanyId;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Data
public class CreateAdminDto {
    private String id;
    private String name;
    private String password;
    private String companyId;


    @Builder
    public CreateAdminDto(String id, String name, String password, String companyId) {
        this.id        = id;
        this.name      = name;
        this.password  = password;
        this.companyId = companyId;
    }

    public AdminEntity toEntity(){
        return AdminEntity.builder()
                .id(this.id)
                .password(password)
                .name(this.name)
                .build();
    }

    public AdminCompanyId toId(){
        return AdminCompanyId.builder().id(this.id)
                .affiliation(this.companyId)
                .build();
    }
}
