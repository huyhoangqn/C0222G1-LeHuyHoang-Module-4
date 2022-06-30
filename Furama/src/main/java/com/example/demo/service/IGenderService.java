package com.example.demo.service;


import com.example.demo.dto.GenderDTO;

import java.util.List;

public interface IGenderService {
    List<GenderDTO> findAllGender();
}
