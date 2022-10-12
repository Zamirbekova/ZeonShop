package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.entity.Commodity;
import com.hadicha.zeonshop.entity.Favorites;
import com.hadicha.zeonshop.service.CommodityService;
import com.hadicha.zeonshop.service.FavoritesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@AllArgsConstructor
public class FavoritesController {
    private final FavoritesService service;
    private final CommodityService commodityService;

    @PostMapping("/{id}")
    public Favorites save(@PathVariable Long id, @RequestBody Favorites favorites) {
        return service.save(id, favorites);
    }

    @GetMapping("/{id}")
    public Commodity getById(@PathVariable Long id) {
        return commodityService.getById(id);
    }

    @GetMapping
    public List<Favorites> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
