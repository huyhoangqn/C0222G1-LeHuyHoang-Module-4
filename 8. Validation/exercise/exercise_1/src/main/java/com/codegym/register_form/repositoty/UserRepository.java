package com.codegym.register_form.repositoty;

import com.codegym.register_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
