package com.codegym.furama.service.impl;

import com.codegym.furama.entity.Gender;
import com.codegym.furama.repository.GenderRepository;
import com.codegym.furama.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService implements IGenderService {
    @Autowired
    GenderRepository genderRepository;
    @Override
    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }
}
