package com.nixsolutions.platform.web.controller;


import com.nixsolutions.platform.facade.LeadFacade;
import com.nixsolutions.platform.web.data.AddressData;
import com.nixsolutions.platform.web.data.CompanyData;
import com.nixsolutions.platform.web.data.LeadData;
import com.nixsolutions.platform.web.data.PageData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

    public final LeadFacade leadFacade;

    public LeadRestController(LeadFacade leadFacade) {
        this.leadFacade = leadFacade;
    }

    @GetMapping
    public ResponseEntity<PageData<LeadData>> findAll(WebRequest request) {
        return ResponseEntity.ok(leadFacade.find(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadData> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(leadFacade.find(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody LeadData leadData) {
        leadFacade.create(leadData);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody LeadData leadData, @PathVariable Integer id) {
        leadData.setId(id);
        leadFacade.update(leadData);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        leadFacade.delete(id);
        return ResponseEntity.ok(true);
    }
}