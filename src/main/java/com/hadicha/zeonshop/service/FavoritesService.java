package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.entity.Favorites;

import java.util.List;

public interface FavoritesService {
    Favorites save(Long id,Favorites favorites);
    Favorites getById(Long id);
    List<Favorites> getAll();
    void deleteById(Long id);
}
