/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.enzogiacoia.security.service;

import com.porfolio.enzogiacoia.security.entity.User;
import com.porfolio.enzogiacoia.security.repository.IUserRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author x3n0g
 */

@Service
@Transactional
public class UserService {
    
    @Autowired
    IUserRepository userRepo;
    
    public Optional<User> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
    public boolean existsByUsername(String username){
        return userRepo.existsByUsername(username);
    }
    
    public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }
    
    public void addUser(User user){
        userRepo.save(user);
    }
}
