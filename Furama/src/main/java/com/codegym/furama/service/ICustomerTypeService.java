package com.codegym.furama.service;


import com.codegym.furama.dto.CustomerTypeDTO;
import com.codegym.furama.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerTypeDTO> findAllCustomerType();

    CustomerType findById(int id);

    void save(CustomerType customerType);

    void remove(int id);
}
