package com.example.demo.service.impl;

import com.example.demo.bean.ServiceType;
import com.example.demo.repository.ServiceTypeRepository;
import com.example.demo.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
