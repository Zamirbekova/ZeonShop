package com.hadicha.zeonshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String name;
    private String surName;
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private boolean agree;

}
