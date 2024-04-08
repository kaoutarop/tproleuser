package com.example.tp2jpa.services;

import com.example.tp2jpa.entities.Role;
import com.example.tp2jpa.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User finfUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName);

    User authenticate(String userName, String password);
}
