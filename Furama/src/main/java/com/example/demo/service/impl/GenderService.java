package com.example.demo.service.impl;

import com.example.demo.dto.GenderDTO;
import com.example.demo.repository.GenderRepository;
import com.example.demo.service.IGenderService;
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
