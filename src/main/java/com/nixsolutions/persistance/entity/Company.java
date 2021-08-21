package com.nixsolutions.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Lead> leadList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Address> addressList = new ArrayList<>();

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name = "industry")
    private String industry;

    @Column(name = "employees")
    private String employees;

    @Column(name = "employees_proof_link")
    private String employeesProofLink;

    @Column(name = "revenue")
    private String revenue;

    @Column(name = "revenue_proof_link")
    private String revenueProofLink;

    @Column(name = "company_comments")
    private String companyComments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    public Company() {
        this.created = new Date();
        this.updated = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updated = new Date();
    }
}
