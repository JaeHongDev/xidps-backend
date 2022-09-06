package domain;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @Column(name="ADMIN_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;
}
