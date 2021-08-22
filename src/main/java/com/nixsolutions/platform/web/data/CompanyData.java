package com.nixsolutions.platform.web.data;

import com.nixsolutions.platform.persistence.entity.Company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CompanyData {

    private Integer id;
    private String companyName;
    private String industry;
    private String employees;
    private String employeesProofLink;
    private String revenue;
    private String revenueProofLink;
    private String companyComments;
    private Date created;
    private Date updated;

    public CompanyData(Company company) {

        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.industry = company.getIndustry();
        this.employees = company.getEmployees();
        this.employeesProofLink = company.getEmployeesProofLink();
        this.revenue = company.getRevenue();
        this.revenueProofLink = company.getRevenueProofLink();
        this.companyComments = company.getCompanyComments();
        this.created = company.getCreated();
        this.updated = company.getUpdated();
    }
}
