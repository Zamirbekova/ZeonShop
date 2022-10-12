package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.ContactRequest;
import com.hadicha.zeonshop.dto.ContactResponse;
import com.hadicha.zeonshop.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {
    private final ContactService service;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping
    public ContactResponse save(@RequestBody ContactRequest request) {
        return service.save(request);
    }
}
