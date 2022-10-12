package com.hadicha.zeonshop.repository;

import com.hadicha.zeonshop.entity.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRepository extends JpaRepository<SocialNetwork,Long> {
}
