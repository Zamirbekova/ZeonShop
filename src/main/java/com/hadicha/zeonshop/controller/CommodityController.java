package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.CommodityPaginationResponse;
import com.hadicha.zeonshop.dto.CommodityRequest;
import com.hadicha.zeonshop.dto.CommodityResponse;
import com.hadicha.zeonshop.entity.Commodity;
import com.hadicha.zeonshop.service.CommodityService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity")
@AllArgsConstructor
public class CommodityController {
    private final CommodityService service;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public CommodityResponse save(@RequestBody CommodityRequest request) {
        return service.save(request);
    }

    @GetMapping("/{id}")
    public Commodity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<Commodity> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/hit")
    public List<Commodity> getAllHit() {
        return service.menu();
    }

    @GetMapping("findByName/{name}")
    public List<Commodity> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/new")
    public List<Commodity> getAllNewsCommodity() {
        return service.getAllNewsCommodity();
    }

    @GetMapping("/pagination")
    public CommodityPaginationResponse getAllWithPagination(@RequestParam int page, @RequestParam int size) {
        return service.getAllPagination(page, size);
    }
    @PutMapping("/{id}")
    public CommodityResponse update(@PathVariable Long id,@RequestBody CommodityRequest request){
        return service.update(id,request);
    }
}
