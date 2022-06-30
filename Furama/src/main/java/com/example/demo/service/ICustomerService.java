package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerDTO> findAllCustomer(Pageable pageable);

    Customer findById(String id);

//    Customer create(Customer customer) throws DuplicateIDException;

    Customer edit(Customer customer) throws DuplicateIDException;

    Customer remove(String id);

    boolean existId(String id);

    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);

    void createCustomer(CustomerDTO customerDTO);
}
