package com.example.demo.service;


import com.example.demo.dto.CustomerTypeDTO;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerTypeDTO> findAllCustomerType();

    CustomerType findById(int id);

    void save(CustomerType customerType);

    void remove(int id);
}
