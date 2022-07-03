package com.example.demo.service.impl;


import com.example.demo.bean.Employee;
import com.example.demo.bean.User;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByName(Pageable pageable, String name) {
        return employeeRepository.findByNameLike(pageable, name);
    }

    @Override
    public Employee findByUser(User user) {
        return employeeRepository.findByUser(user);
    }

    @Override
    public Iterable<Employee> findAllNotPage() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
