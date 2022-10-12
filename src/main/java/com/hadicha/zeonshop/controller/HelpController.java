package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.HelpRequest;
import com.hadicha.zeonshop.dto.HelpResponse;
import com.hadicha.zeonshop.entity.Help;
import com.hadicha.zeonshop.service.HelpService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/help")
@AllArgsConstructor
public class HelpController {
    private final HelpService service;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping
    public HelpResponse save(@RequestBody HelpRequest request) {
        return service.save(request);
    }

    @GetMapping("/{id}")
    public Help getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Help> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
