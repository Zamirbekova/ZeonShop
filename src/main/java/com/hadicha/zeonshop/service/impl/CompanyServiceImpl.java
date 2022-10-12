package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.CompanyRequest;
import com.hadicha.zeonshop.dto.CompanyResponse;
import com.hadicha.zeonshop.entity.Company;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.mapper.CompanyMapper;
import com.hadicha.zeonshop.repository.CompanyRepository;
import com.hadicha.zeonshop.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyMapper mapper;
    @Override
    public CompanyResponse save(CompanyRequest request) {
        return mapper.toDto(repository.save(mapper.save(request)));
    }

    @Override
    public Company getById(Long id) {
        return repository.findById(id).orElseThrow(()->new NotFoundException("not"));
    }
}
