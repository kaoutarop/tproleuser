package com.example.tp2jpa.services;

import com.example.tp2jpa.entities.Role;
import com.example.tp2jpa.entities.User;
import com.example.tp2jpa.repositories.RoleRepository;
import com.example.tp2jpa.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    //@Autowired //injectdependance
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());//UUID permet de generer une chaine de caractere
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User finfUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=finfUserByUserName(username);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

        //userRepository.save(user);
    }
    @Override
    public User authenticate(String userName, String password){
      User user=userRepository.findByUsername(userName);
      if(user==null) throw new RuntimeException("Bad credentials");
      if(user.getPassword().equals(password)){
          return user;
      }
      throw new RuntimeException("Bad credentials");
    }

}
