package com.maaz.SpringSecurity_Example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String greet(HttpServletRequest request){
        return "hello ";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request){

        return "About " + request.getSession().getId();
    }
}
