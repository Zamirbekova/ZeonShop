package com.hadicha.zeonshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequest {
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;
}
