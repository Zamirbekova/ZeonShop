package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Long> {
    List<Commodity> findAllByHitIs(boolean hit);

    @Query("select c from Commodity c where c.isNew = ?1")
    List<Commodity> findAllByNewIs(boolean newa);

    @Query("select c from Commodity c where c.name like %?1%")
    List<Commodity> findByName(String name);

    boolean existsByName(String name);
}
