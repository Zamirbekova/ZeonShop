package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.CommodityPaginationResponse;
import com.hadicha.zeonshop.dto.CommodityRequest;
import com.hadicha.zeonshop.dto.CommodityResponse;
import com.hadicha.zeonshop.entity.Commodity;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.mapper.CommodityMapper;
import com.hadicha.zeonshop.repository.CommodityRepository;
import com.hadicha.zeonshop.service.CommodityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CommodityServiceImpl implements CommodityService {
    private final CommodityRepository repository;
    private final CommodityMapper mapper;

    @Override
    public CommodityResponse save(CommodityRequest commodityRequest) {
        return mapper.toDto(repository.save(mapper.save(commodityRequest)));
    }

    @Override
    public List<Commodity> getAll() {
        return repository.findAll();
    }

    @Override
    public Commodity getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Commodity> menu() {
        return repository.findAllByHitIs(true);

    }

    @Override
    public List<Commodity> getAllNewsCommodity() {
        return repository.findAllByNewIs(true);
    }

    @Override
    public List<Commodity> findByName(String name) {
         repository.findByName(name);
        if (!repository.existsByName(name)) {
            repository.findAll();
        }

        ResponseEntity.ok("po vashemu zaprosu nichego ne naideno");
        ResponseEntity.ok("vozmojno vas interesuet");
        return repository.findAll();
    }

    @Override
    public CommodityResponse update(Long id, CommodityRequest request) {
        Commodity commodity = repository.findById(id).orElseThrow(() -> new NotFoundException("not"));
        commodity.setSize(request.getSize());
        commodity.setVendorCode(request.getVendorCode());
        commodity.setColour(request.getColour());
        commodity.setName(request.getName());
        commodity.setFabricComposition(request.getFabricComposition());
        commodity.setMaterial(request.getMaterial());
        commodity.setNew(request.isNew());
        commodity.setHit(request.isHit());
        commodity.setAmount(request.getAmount());
        commodity.setAbout(request.getAbout());
        if (commodity.getCurrentPrice()!=(request.getCurrentPrice())) {
            double sum = request.getCurrentPrice()*100/commodity.getCurrentPrice();
            commodity.setCurrentPrice(commodity.getCurrentPrice());
            commodity.setPricePercent(request.getCurrentPrice());
            commodity.setPercent(sum);
            return mapper.toDto(repository.save(commodity));
        }
        return mapper.toDto(repository.save(commodity));
    }

    @Override
    public CommodityPaginationResponse getAllPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        CommodityPaginationResponse commodityPaginationResponse = new CommodityPaginationResponse();
        commodityPaginationResponse.setPages((repository.findAll(pageable)).getTotalPages());
        commodityPaginationResponse.setCurrent_page(pageable.getPageNumber());
        commodityPaginationResponse.setCommodityList(repository.findAll(pageable).getContent());
        return commodityPaginationResponse;
    }


}
