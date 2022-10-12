package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
}
