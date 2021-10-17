package com.sl.jwt.repo;

import com.sl.jwt.domain.Role;
import com.sl.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
    
}
