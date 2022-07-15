package com.skillstorm.project2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public List<User> findAll(){
       return repo.findAll();
    }
}
