package com.skillstorm.project2.security;

import javax.servlet.http.Cookie;


/**
 * Used to set Authorization Cookie
 */
public class CookieService {

    private String value = "";

    public CookieService(Cookie[] cookies){
        setCookie(cookies);
    }

    private void setCookie(Cookie[] cookies){
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("Authorization")){

                    value = cookie.getValue();
                }

            }
        }

    }

    public String getValue() {
        return value;
    }





}
