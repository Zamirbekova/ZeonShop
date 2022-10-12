package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends JpaRepository<Help,Long> {
}
