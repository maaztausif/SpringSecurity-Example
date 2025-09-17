package com.maaz.SpringSecurity_Example.controller;

import com.maaz.SpringSecurity_Example.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Maaz","iOS"),
            new Student(2,"maJor","java"))
    );

    @GetMapping("student")
    public List<Student> getAllStudent(){
        return  students;
    }

    @PostMapping("student")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }

    @GetMapping("csfr_token")
    public CsrfToken getCsfrToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
