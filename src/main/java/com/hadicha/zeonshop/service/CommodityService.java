package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.CommodityPaginationResponse;
import com.hadicha.zeonshop.dto.CommodityRequest;
import com.hadicha.zeonshop.dto.CommodityResponse;
import com.hadicha.zeonshop.entity.Commodity;

import java.util.List;

public interface CommodityService {
    CommodityResponse save(CommodityRequest commodityRequest);

    List<Commodity> getAll();

    Commodity getById(Long id);

    void deleteById(Long id);

    List<Commodity> menu();

    List<Commodity> findByName(String name);

    List<Commodity> getAllNewsCommodity();

    CommodityResponse update(Long id, CommodityRequest request);

    CommodityPaginationResponse getAllPagination(int page, int size);
}