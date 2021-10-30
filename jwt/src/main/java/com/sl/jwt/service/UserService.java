package com.sl.jwt.service;

import org.springframework.data.domain.Pageable;

import com.sl.jwt.domain.Role;
import com.sl.jwt.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
