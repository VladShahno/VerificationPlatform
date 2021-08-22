package com.nixsolutions.platform.web.data;

import com.nixsolutions.platform.persistence.entity.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AddressData {

    private Integer id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phoneNumber;
    private Date created;
    private Date updated;

    public AddressData(Address address) {

        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.postalCode = address.getPostalCode();
        this.phoneNumber = address.getPhoneNumber();
        this.created = address.getCreated();
        this.updated = address.getUpdated();
    }
}
