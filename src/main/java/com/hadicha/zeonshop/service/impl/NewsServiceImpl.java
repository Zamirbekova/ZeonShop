package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.NewsRequest;
import com.hadicha.zeonshop.dto.NewsResponse;
import com.hadicha.zeonshop.entity.News;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.mapper.NewsMapper;
import com.hadicha.zeonshop.repository.NewsRepository;
import com.hadicha.zeonshop.service.NewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class NewsServiceImpl implements NewService {
    private final NewsRepository repository;
    private final NewsMapper mapper;

    @Override
    public NewsResponse save(NewsRequest request) {
        return mapper.toDto(repository.save(mapper.save(request)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    @Override
    public List<News> getAll(){
        return repository.findAll();
    }
    @Override
    public News getById(Long id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("not found"));
    }
}
