package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsUserByUserName(String user);
}
