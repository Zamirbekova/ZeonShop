package com.hadicha.zeonshop.service.impl;
import
 com.hadicha.zeonshop.dto.HelpRequest;
import com.hadicha.zeonshop.dto.HelpResponse;
import com.hadicha.zeonshop.entity.Help;
import com.hadicha.zeonshop.exceptions.NotFoundException;
import com.hadicha.zeonshop.mapper.HelpMapper;
import com.hadicha.zeonshop.repository.HelpRepository;
import com.hadicha.zeonshop.service.HelpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class HelpServiceImpl implements HelpService {
    private final HelpRepository repository;
    private final HelpMapper mapper;

    @Override
    public HelpResponse save(HelpRequest helpRequest){
        return mapper.toDto(repository.save(mapper.save(helpRequest)));
    }

    @Override
    public Help getById(Long id) {
        return repository.findById(id).orElseThrow(()->new NotFoundException("not found"));
    }

    @Override
    public List<Help> getAll(){
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
