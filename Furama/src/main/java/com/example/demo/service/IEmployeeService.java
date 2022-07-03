package com.example.demo.service;

import com.example.demo.bean.Employee;
import com.example.demo.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByName(Pageable pageable, String name);

    Employee findByUser(User user);

    Iterable<Employee> findAllNotPage();

    Employee findById(String id);

    void save(Employee employee);

    void delete(Employee employee);
}
