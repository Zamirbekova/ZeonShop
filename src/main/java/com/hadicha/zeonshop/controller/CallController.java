package com.hadicha.zeonshop.controller;

import com.hadicha.zeonshop.dto.CallRequest;
import com.hadicha.zeonshop.dto.CallResponse;
import com.hadicha.zeonshop.entity.Call;
import com.hadicha.zeonshop.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
@AllArgsConstructor
public class CallController {
    private final CallService service;

    @PostMapping
    public Call save(@RequestBody CallRequest request) {
        return service.save(request);
    }
}
