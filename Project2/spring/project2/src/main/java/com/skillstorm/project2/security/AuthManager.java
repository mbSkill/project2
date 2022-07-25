package com.skillstorm.project2.security;

import com.skillstorm.project2.JWTBlacklist.BlackListFilter;
import org.jboss.logging.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
 * AUTHMANAGER set custom http rules
 */
public class AuthManager extends AbstractHttpConfigurer<AuthManager, HttpSecurity> {
    private static final Logger LOGGER = Logger.getLogger(AuthManager.class);
    @Override
    public void configure(HttpSecurity http) throws Exception {

        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http.addFilterBefore(new JWTAuthenticationFilter(authenticationManager),
                UsernamePasswordAuthenticationFilter.class)
                .addFilter(new JWTAuthorizationFilter(authenticationManager))
                .addFilterAfter(new BlackListFilter(), JWTAuthorizationFilter.class);
    }

    public static AuthManager getInstance() {
        return new AuthManager();
    }
}

