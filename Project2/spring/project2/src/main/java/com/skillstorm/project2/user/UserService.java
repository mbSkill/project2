package com.skillstorm.project2.user;

import com.skillstorm.project2.JWTBlacklist.JWTBlacklistRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.skillstorm.project2.security.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillstorm.project2.JWTBlacklist.JWTBlacklist;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

import static com.skillstorm.project2.security.SecurityConstants.SECRET;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    @Autowired
    JWTBlacklistRepository jwtBlacklistRepository;

    public UserService(UserRepository repo, JWTBlacklistRepository jwtBlacklistRepository) {
        this.repo = repo;
        this.jwtBlacklistRepository = jwtBlacklistRepository;
    }

    public List<User> findAll(){
       return repo.findAll();
    }

    public List<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public List<User> findByUsernameAndPassword(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }

    public void invalidateSession(HttpServletRequest request) throws ServletException {

        if (request.getSession() != null && request.getCookies() != null) {
            String token = new CookieService(request.getCookies()).getValue();
            System.out.println(token.toLowerCase());

            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token);
            jwtBlacklistRepository.save(new JWTBlacklist(decodedJWT.getToken(), new Date(System.currentTimeMillis())));
            request.getSession().invalidate();
            request.logout();

        }
    }
}
