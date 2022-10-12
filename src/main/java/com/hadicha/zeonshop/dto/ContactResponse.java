package com.hadicha.zeonshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactResponse {
    private Long id;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;
}
