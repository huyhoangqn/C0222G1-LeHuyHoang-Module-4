package com.codegym.furama.service;


import com.codegym.furama.entity.CustomerType;

public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();

    CustomerType findById(int id);

    void save(CustomerType customerType);

    void remove(int id);
}
