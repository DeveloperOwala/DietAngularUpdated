package com.springboot.employeeAPI.service.impl;

import com.springboot.employeeAPI.model.User;
import com.springboot.employeeAPI.model.UserRole;
import com.springboot.employeeAPI.repository.RoleRepository;
import com.springboot.employeeAPI.repository.UserRepository;
import com.springboot.employeeAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already there");
            throw new Exception("User already present");
        } else{
          // create user
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
           local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userID) {
     this.userRepository.deleteById(userID);
    }
}
