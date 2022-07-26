package com.skillstorm.project2.security;

import com.skillstorm.project2.user.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

/**
 * Gets User by userName from Users database and returns new security.User object
 */
public class UserDetailServiceImp implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(UserDetailsService.class);

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info(username);
        if(userService.findByUsername(username).isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        com.skillstorm.project2.user.User user =
                 userService.findByUsername(username).get(0);

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));



        User u = new User(
                user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()),
                grantedAuthorities
        );

        LOGGER.info("Inside UserDetails" + u);

        return u;
    }
}
