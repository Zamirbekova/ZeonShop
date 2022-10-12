package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.OrderRequest;
import com.hadicha.zeonshop.dto.OrderResponse;
import com.hadicha.zeonshop.exceptions.BadRequestException;
import com.hadicha.zeonshop.mapper.OrderMapper;
import com.hadicha.zeonshop.repository.OrderRepository;
import com.hadicha.zeonshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
private final EmailService emailService;
    @Override
    public OrderResponse save(OrderRequest request) {
        if (request.isAgree()){
            validateEmail(request.getEmail());
            emailService.sendSimpleMessage(request.getEmail(),"Text","mqawsexdrcfyvgbhj");
            return mapper.toDto(repository.save(mapper.save(request)));
        }
        return null;
    }


    private void validateEmail(String email) {
        String emailRegexCase = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern emailPatternCase = Pattern.compile(emailRegexCase);
        Matcher emailCaseValidator = emailPatternCase.matcher(email);

        if (!emailCaseValidator.matches()) {
            throw new BadRequestException("Email has inappropriate characters!");
        }

    }
}
