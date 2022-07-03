package com.example.demo.service.impl;

import com.example.demo.bean.EducationDegree;
import com.example.demo.repository.EducationDegreeRepository;
import com.example.demo.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
