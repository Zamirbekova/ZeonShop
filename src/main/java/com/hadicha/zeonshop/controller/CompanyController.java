package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.CompanyRequest;
import com.hadicha.zeonshop.dto.CompanyResponse;
import com.hadicha.zeonshop.entity.Company;
import com.hadicha.zeonshop.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {
    private final CompanyService service;

    @PostMapping
    public CompanyResponse save(@RequestBody CompanyRequest request) {
        return service.save(request);
    }
    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id){
        return service.getById(id);
    }
}
