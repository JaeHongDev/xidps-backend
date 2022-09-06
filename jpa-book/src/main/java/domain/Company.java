package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @Column(name="company_id")
    private String id;


    @OneToMany
    @JoinColumn(name="company_id")
    private List<Admin> admins;

}
