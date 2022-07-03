package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    private String userName;

    private String passWord;

    public User() {
    }
    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
