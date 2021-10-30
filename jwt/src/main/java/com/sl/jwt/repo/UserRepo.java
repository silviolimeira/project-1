package com.sl.jwt.repo;

import com.sl.jwt.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    //@Query("select u from User")
    List<User> findAll();

}
