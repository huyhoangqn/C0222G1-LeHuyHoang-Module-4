package com.example.demo.service.impl;

import com.example.demo.bean.Division;
import com.example.demo.repository.DivisionRepository;
import com.example.demo.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}
