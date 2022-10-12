package com.hadicha.zeonshop.jwt.securityConfig;

import com.hadicha.zeonshop.jwt.JwtConfig;
import com.hadicha.zeonshop.jwt.JwtTokenVerifier;
import com.hadicha.zeonshop.jwt.JwtUtils;
import com.hadicha.zeonshop.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
@AllArgsConstructor
@Slf4j
@Order(1)
public class WebAppSecurity extends WebSecurityConfigurerAdapter {
    private final AdminRepository authInfoRepository;
    private final JwtConfig jwtConfig;
    private final JwtUtils jwtUtils;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(getUserDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return (email) -> authInfoRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.error("{} is not registered", email);
                    throw new BadCredentialsException(
                            String.format("%s is not registered", email)
                    );
                });
    }


    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.cors().and().csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                    .authorizeRequests()
                    .antMatchers("/swagger-ui.html").permitAll()
                    .anyRequest()
                    .permitAll();
        } catch (Exception e) {
            log.error("Incorrect credentials");
        }

        http.addFilterBefore(
                new JwtTokenVerifier(
                        jwtConfig,
                        jwtUtils,
                        getUserDetailsService()),
                UsernamePasswordAuthenticationFilter.class
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


}

