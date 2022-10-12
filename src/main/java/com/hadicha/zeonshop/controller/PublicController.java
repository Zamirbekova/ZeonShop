package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.PublicRequest;
import com.hadicha.zeonshop.dto.PublicResponse;
import com.hadicha.zeonshop.entity.Public;
import com.hadicha.zeonshop.service.PublicService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
@AllArgsConstructor
public class  PublicController {
    private final PublicService service;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public PublicResponse save(@RequestBody PublicRequest request) {
        return service.save(request);
    }
    @GetMapping
    public List<Public> getALl(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Public getById(@PathVariable Long id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
