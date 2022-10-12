package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Long> {
}
