package com.springboot.employeeAPI.service;

import com.springboot.employeeAPI.model.User;
import com.springboot.employeeAPI.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface UserService {
    //create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;


    // get user by username
    public User getUser(String username);
    // delete user by user ID
    public void deleteUser(Long userID);
}
