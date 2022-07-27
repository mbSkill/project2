package com.skillstorm.project2.JWTBlacklist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTBlacklistRepository extends JpaRepository<JWTBlacklist, String> {

}
