package com.hadicha.zeonshop.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
@ConfigurationProperties("application.jwt")
@Getter
@Setter
public class JwtConfig {
    private final String secretKey = "zeon";
    private final String tokenPrefix = "Bearer";
    private final Long expirationDateAfterDays = 60L;

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;

    }
}