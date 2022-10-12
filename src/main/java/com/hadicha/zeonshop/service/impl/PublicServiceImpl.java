package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.PublicRequest;
import com.hadicha.zeonshop.dto.PublicResponse;
import com.hadicha.zeonshop.entity.Public;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.mapper.PublicMapper;
import com.hadicha.zeonshop.repository.PublicRepository;
import com.hadicha.zeonshop.service.PublicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PublicServiceImpl implements PublicService {
    private final PublicRepository repository;
    private final PublicMapper mapper;

    @Override
    public PublicResponse save(PublicRequest publicRequest) {
        return mapper.toDto(repository.save(mapper.save(publicRequest)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Public> getAll() {
        return repository.findAll();
    }

    @Override
    public Public getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }
}
