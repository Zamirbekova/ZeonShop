package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.ContactRequest;
import com.hadicha.zeonshop.dto.ContactResponse;

public interface ContactService {
    ContactResponse save(ContactRequest request);
}
