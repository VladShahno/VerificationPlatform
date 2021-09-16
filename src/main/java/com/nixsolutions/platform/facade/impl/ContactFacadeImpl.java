package com.nixsolutions.platform.facade.impl;

import com.nixsolutions.platform.facade.ContactFacade;
import com.nixsolutions.platform.persistence.entity.Address;
import com.nixsolutions.platform.persistence.entity.Company;
import com.nixsolutions.platform.persistence.entity.Lead;
import com.nixsolutions.platform.service.AddressService;
import com.nixsolutions.platform.service.CompanyService;
import com.nixsolutions.platform.service.LeadService;
import com.nixsolutions.platform.util.WebRequestUtil;
import com.nixsolutions.platform.web.dto.LeadDto;
import com.nixsolutions.platform.web.dto.PageData;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.nixsolutions.platform.util.WebRequestUtil.*;

@Service
public class ContactFacadeImpl implements ContactFacade {

    private final LeadService leadService;
    private final CompanyService companyService;
    private final AddressService addressService;

    public ContactFacadeImpl(LeadService leadService, CompanyService companyService, AddressService addressService) {
        this.leadService = leadService;
        this.companyService = companyService;
        this.addressService = addressService;
    }

    @Override
    public void create(LeadDto leadDto) {

        Lead lead = new Lead();
        Company company = new Company();
        Address address = new Address();

        copyCompanyProperties(leadDto, company);
        companyService.create(company);

        lead.setCompany(company);
        address.setCompany(company);

        copyAddressProperties(leadDto, address);
        addressService.create(address);

        copyLeadProperties(leadDto, lead);
        leadService.create(lead);
    }

    @Override
    public void update(LeadDto leadDto) {
        if (leadDto.getId() != null) {
            Lead lead = leadService.find(leadDto.getId());
            Company company = companyService.find(leadDto.getCompanyData().getId());
            Address address = addressService.find(leadDto.getAddressData().getId());

            copyCompanyProperties(leadDto, company);
            copyAddressProperties(leadDto, address);
            copyLeadProperties(leadDto, lead);

            companyService.update(company);
            address.setCompany(company);
            lead.setAddress(address);
            addressService.update(address);
            lead.setCompany(company);
            leadService.update(lead);
        }
    }

    @Override
    public void delete(Integer id) {
        leadService.delete(id);
    }

    @Override
    public LeadDto find(Integer id) {
        return new LeadDto(leadService.find(id));
    }

    @Override
    public PageData<LeadDto> find(WebRequest request) {
        Map<String, String> params = WebRequestUtil.getParametersMap(request);
        PageData<LeadDto> pageData = new PageData<>();
        pageData.setSort(params.get(SORT_PARAM));
        pageData.setOrder(params.get(ORDER_PARAM));
        pageData.setCurrentPage(Integer.parseInt(params.get(PAGE_PARAM)));
        pageData.setPageSize(Integer.parseInt(params.get(SIZE_PARAM)));
        Page<Lead> leads = leadService.find(params);
        pageData.setTotalElements(leads.getTotalElements());
        pageData.setTotalPages(leads.getTotalPages());
        if (CollectionUtils.isNotEmpty(leads.getContent())) {
            List<LeadDto> list = leads.getContent().stream().map(LeadDto::new).collect(Collectors.toList());
            pageData.setItems(list);
        }
        pageData.initPaginationState(pageData.getCurrentPage());
        return pageData;
    }

    private void copyLeadProperties(LeadDto leadDto, Lead lead) {
        lead.setFirstName(leadDto.getFirstName());
        lead.setLastName(leadDto.getLastName());
        lead.setEmail(leadDto.getEmail());
        lead.setTitle(leadDto.getTitle());
        lead.setProofLink(leadDto.getProofLink());
        lead.setVerdict(leadDto.getVerdict());
        lead.setLeadComments(leadDto.getLeadComments());
    }

    private void copyCompanyProperties(LeadDto leadDto, Company company) {
        company.setCompanyName(leadDto.getCompanyData().getCompanyName());
        company.setIndustry(leadDto.getCompanyData().getIndustry());
        company.setEmployees(leadDto.getCompanyData().getEmployees());
        company.setEmployeesProofLink(leadDto.getCompanyData().getEmployeesProofLink());
        company.setRevenue(leadDto.getCompanyData().getRevenue());
        company.setRevenueProofLink(leadDto.getCompanyData().getRevenueProofLink());
        company.setCompanyComments(leadDto.getCompanyData().getCompanyComments());
    }

    private void copyAddressProperties(LeadDto leadDto, Address address) {
        address.setId(leadDto.getAddressData().getId());
        address.setCountry(leadDto.getAddressData().getCountry());
        address.setStreet(leadDto.getAddressData().getStreet());
        address.setCity(leadDto.getAddressData().getCity());
        address.setState(leadDto.getAddressData().getState());
        address.setPostalCode(leadDto.getAddressData().getPostalCode());
        address.setPhoneNumber(leadDto.getAddressData().getPhoneNumber());
    }
}