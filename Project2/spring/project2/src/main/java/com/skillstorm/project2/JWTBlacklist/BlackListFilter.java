package com.skillstorm.project2.JWTBlacklist;


/*
 * Filter used to check if the authentication token sent was previously
 * Blacklisted. This is needed to invalidate tokens that have not expired yet.
 * Examples could be users logging out or a password change.
 * */

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.skillstorm.project2.security.SecurityConstants.*;

@Component
public class BlackListFilter extends GenericFilterBean {
    private static final Logger LOGGER = Logger.getLogger(BlackListFilter.class);
    JWTBlacklistRepository jwtBlacklistRepository;


    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        //Get JWTRepo object from context
        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        jwtBlacklistRepository = webApplicationContext.getBean(JWTBlacklistRepository.class);

        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(HEADER_STRING);

        if(token != null) {

            try{

                DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                        .build()
                        .verify(token.replace(TOKEN_PREFIX, ""));

                TokenAuthentication attributes = new TokenAuthentication(decodedJWT);
                // Checks if the Token has been flagged as invalid by a logout action
                if (jwtBlacklistRepository.existsById(attributes.getToken())) {
                    return;
                }

            }catch (TokenExpiredException e){
                LOGGER.debug("Ohh no" + e.getMessage());
                return;

            }catch (JWTDecodeException e){
                LOGGER.debug(e.getMessage());
            }

        }

        chain.doFilter( request, response);
    }


}



