package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.AdminRequest;
import com.hadicha.zeonshop.dto.AdminResponse;

public interface AdminService {
    AdminResponse authenticate(AdminRequest request);

}
