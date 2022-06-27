package com.codegym.furama.service;


import com.codegym.furama.dto.GenderDTO;

import java.util.List;

public interface IGenderService {
    List<GenderDTO> findAllGender();
}
