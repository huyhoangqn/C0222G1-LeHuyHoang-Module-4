package com.example.demo.repository;


import com.example.demo.dto.GenderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
    @Query(value = "SELECT new com.example.demo.dto.GenderDTO(g.genderId, g.gender) FROM Gender g")
    List<GenderDTO> findAllGender();
}
