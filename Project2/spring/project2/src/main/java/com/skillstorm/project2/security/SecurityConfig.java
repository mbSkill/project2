package com.skillstorm.project2.security;

import com.skillstorm.project2.controllers.LogoutHandlerjwtInvalidate;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final Logger LOGGER = Logger.getLogger(SecurityConfig.class);
    @Autowired
    LogoutHandler LogoutHandlerjwtInvalidate;
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImp();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(5);
    }

    @Bean
    public AuthManager authManager(){
        return AuthManager.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf().disable().cors().and()
            .authorizeRequests(authorize -> authorize
                    .antMatchers("/**").permitAll()

            )
            .formLogin(withDefaults())
            .logout().addLogoutHandler(LogoutHandlerjwtInvalidate).clearAuthentication(true).deleteCookies("Authorization")
            .and()
            .httpBasic(withDefaults())
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .apply(authManager());
        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web;
//    }


}
