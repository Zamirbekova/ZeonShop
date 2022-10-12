package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {
}
