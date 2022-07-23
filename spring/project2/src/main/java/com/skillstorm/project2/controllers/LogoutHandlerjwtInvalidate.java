package com.skillstorm.project2.controllers;

import com.skillstorm.project2.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LogoutHandlerjwtInvalidate implements LogoutHandler {

    @Autowired
    UserService userService;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            userService.invalidateSession(request);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
