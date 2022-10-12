package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.CallRequest;
import com.hadicha.zeonshop.dto.CallResponse;
import com.hadicha.zeonshop.entity.Call;

public interface CallService {
    Call save(CallRequest request);
}


