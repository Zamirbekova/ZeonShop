package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.entity.Basket;

import java.util.List;

public interface BasketService {

    Basket save(Long id,Basket basket);
    void deleteById(Long id);
    Basket getById(Long id);
    List<Basket> getAll();

}
