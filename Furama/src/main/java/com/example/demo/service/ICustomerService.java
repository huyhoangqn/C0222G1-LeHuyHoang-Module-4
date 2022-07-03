package com.example.demo.service;

import com.example.demo.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> showAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(String id);

    void delete(Customer customer);

    Page<Customer> findByName(Pageable pageable, String name);

    Iterable<Customer> findAll();
}
