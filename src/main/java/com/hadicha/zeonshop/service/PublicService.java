package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.PublicRequest;
import com.hadicha.zeonshop.dto.PublicResponse;
import com.hadicha.zeonshop.entity.Public;

import java.util.List;

public interface PublicService {
    PublicResponse save(PublicRequest request);
    Public getById(Long id);
    List<Public> getAll();
    void  delete(Long id);
}
