package com.codegym.furama.service.impl;

import com.codegym.furama.dto.GenderDTO;
import com.codegym.furama.repository.GenderRepository;
import com.codegym.furama.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService implements IGenderService {
    @Autowired
    GenderRepository genderRepository;

    @Override
    public List<GenderDTO> findAllGender() {
        return genderRepository.findAllGender();
    }
}
