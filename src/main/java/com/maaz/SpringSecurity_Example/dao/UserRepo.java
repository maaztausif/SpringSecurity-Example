package com.maaz.SpringSecurity_Example.dao;

import com.maaz.SpringSecurity_Example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

   User findByusername(String username);
}
