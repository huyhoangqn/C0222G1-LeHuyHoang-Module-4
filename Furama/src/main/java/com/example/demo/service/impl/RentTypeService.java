package com.example.demo.service.impl;

import com.example.demo.bean.RentType;
import com.example.demo.repository.RentTypeRepository;
import com.example.demo.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
