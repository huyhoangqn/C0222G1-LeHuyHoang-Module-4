package com.example.demo.service;

import com.example.demo.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> showAll(Pageable pageable);

    Customer save(Customer customer);

    Customer findById(String id);

    void delete(Customer customer);

    Page<Customer> findByName(Pageable pageable, String name);

    List<Customer> findAll();

    List<Customer> findAllCustomer();
}
