package com.nixsolutions.platform.facade.impl;

import com.nixsolutions.platform.facade.LeadFacade;
import com.nixsolutions.platform.persistence.entity.Address;
import com.nixsolutions.platform.persistence.entity.Company;
import com.nixsolutions.platform.persistence.entity.Lead;
import com.nixsolutions.platform.service.AddressService;
import com.nixsolutions.platform.service.CompanyService;
import com.nixsolutions.platform.service.LeadService;
import com.nixsolutions.platform.util.WebRequestUtil;
import com.nixsolutions.platform.web.data.AddressData;
import com.nixsolutions.platform.web.data.CompanyData;
import com.nixsolutions.platform.web.data.LeadData;
import com.nixsolutions.platform.web.data.PageData;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.nixsolutions.platform.util.WebRequestUtil.*;

@Service
public class LeadFacadeImpl implements LeadFacade {

    private final LeadService leadService;
    private final CompanyService companyService;
    private final AddressService addressService;

    public LeadFacadeImpl(LeadService leadService, CompanyService companyService, AddressService addressService) {
        this.leadService = leadService;
        this.companyService = companyService;
        this.addressService = addressService;
    }

    @Override
    public void create(LeadData leadData) {
        Lead lead = new Lead();
        copyLeadProperties(leadData, lead);
        leadService.create(lead);
    }

    @Override
    public void update(LeadData leadData) {
        if (leadData.getId() != null) {
            Lead lead = leadService.find(leadData.getId());
            copyLeadProperties(leadData, lead);
            leadService.update(lead);
        } else
            throw new RuntimeException("Lead with id - " + leadData.getId() + " does not exist!");
    }

    @Override
    public void delete(Integer id) {
        leadService.delete(id);
    }

    @Override
    public LeadData find(Integer id) {
        return new LeadData(leadService.find(id));
    }

    @Override
    public PageData<LeadData> find(WebRequest request) {
        Map<String, String> params = WebRequestUtil.getParametersMap(request);
        PageData<LeadData> pageData = new PageData<>();
        pageData.setSort(params.get(SORT_PARAM));
        pageData.setOrder(params.get(ORDER_PARAM));
        pageData.setCurrentPage(Integer.parseInt(params.get(PAGE_PARAM)));
        pageData.setPageSize(Integer.parseInt(params.get(SIZE_PARAM)));
        Page<Lead> leads = leadService.find(params);
        pageData.setTotalElements(leads.getTotalElements());
        pageData.setTotalPages(leads.getTotalPages());
        if (CollectionUtils.isNotEmpty(leads.getContent())) {
            List<LeadData> list = leads.getContent().stream().map(LeadData::new).collect(Collectors.toList());
            pageData.setItems(list);
        }
        pageData.initPaginationState(pageData.getCurrentPage());
        return pageData;
    }

    private void copyLeadProperties(LeadData leadData, Lead lead) {
        lead.setFirstName(leadData.getFirstName());
        lead.setLastName(leadData.getLastName());
        lead.setEmail(leadData.getEmail());
        lead.setTitle(leadData.getTitle());
        lead.setProofLink(leadData.getProofLink());
        lead.setVerdict(leadData.getVerdict());
        lead.setLeadComments(leadData.getLeadComments());
    }

    private void copyCompanyProperties(CompanyData companyData, Company company) {
        company.setCompanyName(companyData.getCompanyName());
        company.setIndustry(companyData.getIndustry());
        company.setEmployees(companyData.getEmployees());
        company.setEmployeesProofLink(companyData.getEmployeesProofLink());
        company.setRevenue(companyData.getRevenue());
        company.setRevenueProofLink(companyData.getRevenueProofLink());
        company.setCompanyComments(companyData.getCompanyComments());
    }

    private void copyAddressProperties(AddressData addressData, Address address) {
        address.setCountry(addressData.getCountry());
        address.setStreet(addressData.getStreet());
        address.setCity(addressData.getCity());
        address.setState(addressData.getPostalCode());
        address.setPostalCode(addressData.getPostalCode());
        address.setPhoneNumber(addressData.getPhoneNumber());
    }
}