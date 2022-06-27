package com.codegym.furama.repository;


import com.codegym.furama.dto.GenderDTO;
import com.codegym.furama.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
    @Query(value = "SELECT new com.codegym.furama.dto.GenderDTO(g.genderId, g.gender) FROM Gender g")
    List<GenderDTO> findAllGender();
}
