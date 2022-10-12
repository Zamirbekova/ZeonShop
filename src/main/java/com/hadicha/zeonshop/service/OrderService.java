package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.OrderRequest;
import com.hadicha.zeonshop.dto.OrderResponse;

public interface OrderService {
    OrderResponse save(OrderRequest request);
}
