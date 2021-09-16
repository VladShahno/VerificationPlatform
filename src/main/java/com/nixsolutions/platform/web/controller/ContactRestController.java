package com.nixsolutions.platform.web.controller;

import com.nixsolutions.platform.facade.ContactFacade;
import com.nixsolutions.platform.web.dto.LeadDto;
import com.nixsolutions.platform.web.dto.PageData;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {

    public final ContactFacade contactFacade;

    public ContactRestController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @GetMapping
    public ResponseEntity<PageData<LeadDto>> findAll(WebRequest request) {
        return ResponseEntity.ok(contactFacade.find(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(contactFacade.find(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody LeadDto leadDto) {
        contactFacade.create(leadDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody LeadDto leadDto, @PathVariable Integer id) {
        leadDto.setId(id);
        contactFacade.update(leadDto);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        contactFacade.delete(id);
        return ResponseEntity.ok(true);
    }
}