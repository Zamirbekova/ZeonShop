package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.CallRequest;
import com.hadicha.zeonshop.dto.CallResponse;
import com.hadicha.zeonshop.entity.Call;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Access;

@Component
@Slf4j
public class CallMapper extends AbstractMapper<Call, CallResponse> {

@Autowired
    public CallMapper() {
        super(Call.class,CallResponse.class);
    }

    public Call save(CallRequest request) {
        Call call = new Call();
        call.setName(request.getName());
        call.setPhoneNumber(request.getPhoneNumber());
        return call;
    }
}
