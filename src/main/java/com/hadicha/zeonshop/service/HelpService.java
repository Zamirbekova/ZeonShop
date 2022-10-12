package com.hadicha.zeonshop.service;

import com.hadicha.zeonshop.dto.HelpRequest;
import com.hadicha.zeonshop.dto.HelpResponse;
import com.hadicha.zeonshop.entity.Help;

import java.util.List;

public interface HelpService {
    HelpResponse save(HelpRequest helpRequest);
    Help getById(Long id);
    List<Help> getAll();
    void deleteById(Long id);

}
