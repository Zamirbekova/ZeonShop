package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.CompanyRequest;
import com.hadicha.zeonshop.dto.CompanyResponse;
import com.hadicha.zeonshop.entity.Company;

public interface CompanyService {
    CompanyResponse save(CompanyRequest request);

    Company getById(Long id);
}
