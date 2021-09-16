package com.nixsolutions.platform.web.dto;

import com.nixsolutions.platform.persistence.entity.Address;
import com.nixsolutions.platform.persistence.entity.Company;
import com.nixsolutions.platform.persistence.entity.Lead;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LeadDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String proofLink;
    private String verdict;
    private String leadComments;
    private Date created;
    private Date updated;
    private Company companyData;
    private Address addressData;

    public LeadDto(Lead lead) {

        this.id = lead.getId();
        this.firstName = lead.getFirstName();
        this.lastName = lead.getLastName();
        this.email = lead.getEmail();
        this.title = lead.getTitle();
        this.proofLink = lead.getProofLink();
        this.verdict = lead.getVerdict();
        this.leadComments = lead.getLeadComments();
        this.created = lead.getCreated();
        this.updated = lead.getUpdated();
        this.companyData = lead.getCompany();
        this.addressData = lead.getAddress();
    }
}
