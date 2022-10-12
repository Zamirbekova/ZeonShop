package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.ContactRequest;
import com.hadicha.zeonshop.dto.ContactResponse;
import com.hadicha.zeonshop.mapper.ContactMapper;
import com.hadicha.zeonshop.repository.ContactRepository;
import com.hadicha.zeonshop.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ContactServiceImpl implements ContactService {
    private final ContactMapper mapper;
    private final ContactRepository repository;

    @Override
    public ContactResponse save(ContactRequest contactRequest) {
        return mapper.toDto(repository.save(mapper.save(contactRequest)));
    }
}
