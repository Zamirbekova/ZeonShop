package com.hadicha.zeonshop.typeRole;

import org.springframework.security.core.GrantedAuthority;

public enum AuthorityType implements GrantedAuthority {

    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}



