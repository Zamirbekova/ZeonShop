package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.entity.Basket;
import com.hadicha.zeonshop.entity.Commodity;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.repository.BasketRepository;
import com.hadicha.zeonshop.repository.CommodityRepository;
import com.hadicha.zeonshop.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BasketServiceImpl implements BasketService {
    private final BasketRepository repository;
    private final CommodityRepository commodityRepository;

    @Override
    public Basket save(Long id, Basket basket) {
        Commodity commodity = commodityRepository.findById(id).get();
        Basket basket1 = repository.save(basket);
        basket1.setCommodityId(commodity.getId());
        return basket1;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Basket getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("not"));
    }

    @Override
    public List<Basket> getAll() {
        return repository.findAll();
    }

}
