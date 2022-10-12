package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends JpaRepository<Call,Long> {
}
