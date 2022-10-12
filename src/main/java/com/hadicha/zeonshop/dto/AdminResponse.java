package com.hadicha.zeonshop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdminResponse {
    private String token;
    private String email;
}
