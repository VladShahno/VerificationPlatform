package com.nixsolutions.platform.web.data;

import com.nixsolutions.platform.persistence.entity.Lead;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LeadData {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String proofLink;
    private String verdict;
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
        this.created = lead.getCreated();
        this.updated = lead.getUpdated();
    }
}
