package com.hadicha.zeonshop.service.impl;

import com.hadicha.zeonshop.dto.AdminRequest;
import com.hadicha.zeonshop.dto.AdminResponse;
import com.hadicha.zeonshop.jwt.JwtUtils;
import com.hadicha.zeonshop.repository.AdminRepository;
import com.hadicha.zeonshop.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;
    private final JwtUtils utils;
    private final AuthenticationManager authenticationManager;

    @Override
    public AdminResponse authenticate(AdminRequest request) {
        String generatedToken = getGeneratedToken(request.getEmail(), request.getPassword());

//        Admin admin = repository.findByEmail(request.getEmail())
//                .orElseThrow(() -> {
//                    log.error("User  email = {} is not registered", request.getEmail());
//                    throw new NotFoundException(
//                            String.format("User  email {} is not registered", request.getEmail())
//                    );
//                });
        return AdminResponse.builder().email(request.getEmail()).token(generatedToken).build();
    }

    public String getGeneratedToken(String email, String password) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                email,
                password
        ));
        String generatedToken = utils.generateToken(authentication);
        return generatedToken;

    }

}
