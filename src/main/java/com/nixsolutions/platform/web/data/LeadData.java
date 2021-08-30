package com.nixsolutions.platform.web.data;

import com.nixsolutions.platform.persistence.entity.Lead;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LeadData {

    @Autowired
    private final AddressData addressData = new AddressData();
    @Autowired
    private final CompanyData companyData = new CompanyData();

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

    public LeadData(Lead lead) {

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
    }
}
