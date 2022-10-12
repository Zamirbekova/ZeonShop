package com.hadicha.zeonshop;

import com.hadicha.zeonshop.entity.Admin;
import com.hadicha.zeonshop.repository.AdminRepository;
import com.hadicha.zeonshop.typeRole.AuthorityType;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class ZeonShopApplication {
    private final AdminRepository authInfoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ZeonShopApplication.class, args);
    }

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initBusiness() {
        Admin admin = new Admin();
        admin.setEmail("admin@gmail.com");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(AuthorityType.ROLE_ADMIN);
        authInfoRepository.save(admin);
    }
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.hadicha.zeonshop")).build();
    }
}



