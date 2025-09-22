package com.maaz.SpringSecurity_Example.controller;

import com.maaz.SpringSecurity_Example.dao.UserRepo;
import com.maaz.SpringSecurity_Example.model.User;
import com.maaz.SpringSecurity_Example.model.UserPrincipal;
import com.maaz.SpringSecurity_Example.service.JwtService;
import com.maaz.SpringSecurity_Example.service.UserService;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

//    public User saveUSer(User user){
//       return service.//repo.save(user);
//    }

    @PostMapping("register")
    public User Register(@RequestBody User user){
        return service.userSave(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else {
            return "false";
        }
    }
}
