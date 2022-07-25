package com.skillstorm.project2.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.skillstorm.project2.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger LOGGER = Logger.getLogger(JWTAuthenticationFilter.class);
    private AuthenticationManager authManager;

    public JWTAuthenticationFilter(AuthenticationManager authManager){
        this.authManager = authManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {

            com.skillstorm.project2.user.User user = new ObjectMapper().readValue(request.getInputStream(),
                    com.skillstorm.project2.user.User.class);
            LOGGER.info("Inside AttemptAuth " + user);

            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    new ArrayList<GrantedAuthority>()));

                    LOGGER.info("in attemptAuthentication for: " + authentication.getName());

        return authentication;

        } catch (IOException e) {
            LOGGER.info("THROW IOE");
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        LOGGER.info(authResult.getAuthorities());
        String jwt = JWT.create()
                    .withSubject(((User) authResult.getPrincipal()).getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(Algorithm.HMAC512(SECRET.getBytes()));


        response.addCookie(new Cookie("Authorization",jwt));
        response.addCookie(new Cookie("userName", authResult.getName()));
    }


}
