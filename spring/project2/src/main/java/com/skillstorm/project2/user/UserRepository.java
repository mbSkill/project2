package com.skillstorm.project2.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsernameAndPassword(String username, String password);
    List<User> findByUsername(String username);

}
