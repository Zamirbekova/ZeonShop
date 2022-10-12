package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.NewsRequest;
import com.hadicha.zeonshop.dto.NewsResponse;
import com.hadicha.zeonshop.entity.News;
import com.hadicha.zeonshop.service.NewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@AllArgsConstructor
public class NewsController {
    private final NewService service;

    @PostMapping
    public NewsResponse save(@RequestBody NewsRequest request) {
        return service.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public News getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<News> getAll() {
        return service.getAll();
    }
}
