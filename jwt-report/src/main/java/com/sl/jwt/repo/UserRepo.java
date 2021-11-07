package com.sl.jwt.repo;

import com.sl.jwt.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
