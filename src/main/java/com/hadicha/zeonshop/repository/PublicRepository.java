package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.Public;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicRepository extends JpaRepository<Public,Long> {
}
