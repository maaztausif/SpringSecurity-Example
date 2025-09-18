package com.maaz.SpringSecurity_Example.service;

import com.maaz.SpringSecurity_Example.dao.UserRepo;
import com.maaz.SpringSecurity_Example.model.User;
import com.maaz.SpringSecurity_Example.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  repo.findByusername(username);
        if (user == null){
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user);
    }


}
