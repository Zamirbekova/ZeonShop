package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.OrderRequest;
import com.hadicha.zeonshop.dto.OrderResponse;
import com.hadicha.zeonshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService service;
    @PostMapping
    public OrderResponse save(@RequestBody OrderRequest request){
        return service.save(request);
    }
}
