package com.maaz.SpringSecurity_Example.service;

import com.maaz.SpringSecurity_Example.dao.UserRepo;
import com.maaz.SpringSecurity_Example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User userSave(User user){
        user.setPassword(encoder.encode(user.getPassword()));
       return repo.save(user);
    }
}
