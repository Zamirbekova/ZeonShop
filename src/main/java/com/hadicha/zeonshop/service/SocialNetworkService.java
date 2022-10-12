package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.SocialNetworkRequest;
import com.hadicha.zeonshop.dto.SocialNetworkResponse;

public interface SocialNetworkService {
    SocialNetworkResponse save(SocialNetworkRequest request);
}
