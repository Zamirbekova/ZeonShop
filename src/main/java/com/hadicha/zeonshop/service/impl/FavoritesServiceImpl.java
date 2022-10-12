package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.entity.Commodity;
import com.hadicha.zeonshop.entity.Favorites;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.repository.CommodityRepository;
import com.hadicha.zeonshop.repository.FavoritesRepository;
import com.hadicha.zeonshop.service.FavoritesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class FavoritesServiceImpl implements FavoritesService {
    private final FavoritesRepository repository;
    private final CommodityRepository commodityRepository;

    @Override
    public Favorites save(Long id, Favorites favorites) {
        Commodity commodity = commodityRepository.findById(id).get();
        Favorites favorites1 = repository.save(favorites);
        favorites1.setCommodityId(commodity.getId());
        return favorites1;
    }

    @Override
    public Favorites getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public List<Favorites> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
