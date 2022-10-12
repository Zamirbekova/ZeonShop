package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.AdminRequest;
import com.hadicha.zeonshop.dto.AdminResponse;
import com.hadicha.zeonshop.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService service;

    @PostMapping
    @PermitAll
    public AdminResponse authenticate(@RequestBody AdminRequest admin) {
        return service.authenticate(admin);
    }
}
