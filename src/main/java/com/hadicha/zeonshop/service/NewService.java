package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.NewsRequest;
import com.hadicha.zeonshop.dto.NewsResponse;
import com.hadicha.zeonshop.entity.News;

import java.util.List;

public interface NewService {
    NewsResponse save(NewsRequest request);
    void delete(Long id);
    News getById(Long id);
    List<News> getAll();

}
