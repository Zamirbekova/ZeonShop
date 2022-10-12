package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.SocialNetworkRequest;
import com.hadicha.zeonshop.dto.SocialNetworkResponse;
import com.hadicha.zeonshop.mapper.SocialMapper;
import com.hadicha.zeonshop.repository.SocialNetworkRepository;
import com.hadicha.zeonshop.service.SocialNetworkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class SocialNetworkServiceImpl implements SocialNetworkService {
    private final SocialNetworkRepository repository;
    private final SocialMapper mapper;

    @Override
    public SocialNetworkResponse save(SocialNetworkRequest request) {
        return mapper.toDto(repository.save(mapper.save(request)));
    }
}
