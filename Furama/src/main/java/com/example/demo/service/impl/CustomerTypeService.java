package com.example.demo.service.impl;


import com.example.demo.dto.CustomerTypeDTO;
import com.example.demo.repository.CustomerTypeRepository;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerTypeDTO> findAllCustomerType() {
        return customerTypeRepository.findAllCustomerType();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(int id) {
        customerTypeRepository.deleteById(id);
    }
}
