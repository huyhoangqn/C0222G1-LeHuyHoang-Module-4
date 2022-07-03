package com.example.demo.service;

import com.example.demo.bean.CustomerType;

public interface ITypeOfCustomerService {
    Iterable<CustomerType> findAll();
}
