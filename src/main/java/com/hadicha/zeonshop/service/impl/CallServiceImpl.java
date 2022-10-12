package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.CallRequest;
import com.hadicha.zeonshop.dto.CallResponse;
import com.hadicha.zeonshop.entity.Call;
import com.hadicha.zeonshop.mapper.CallMapper;
import com.hadicha.zeonshop.repository.CallRepository;
import com.hadicha.zeonshop.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CallServiceImpl implements CallService {
    private final CallRepository repository;
    private final CallMapper mapper;
    public Call save(CallRequest request){
        return repository.save(mapper.save(request));
    }

}
