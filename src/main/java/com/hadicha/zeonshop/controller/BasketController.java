package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.entity.Basket;
import com.hadicha.zeonshop.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
@AllArgsConstructor
public class BasketController {
    private final BasketService service;

    @PostMapping("/{id}")
    public Basket save(@PathVariable Long id, @RequestBody Basket basket) {
        return service.save(id, basket);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Basket getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Basket> getAll() {
        return service.getAll();
    }

}
