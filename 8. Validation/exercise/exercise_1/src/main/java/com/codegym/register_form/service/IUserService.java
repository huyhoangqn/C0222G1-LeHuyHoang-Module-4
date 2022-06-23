package com.codegym.register_form.service;


import com.codegym.register_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void create(User user);
}
