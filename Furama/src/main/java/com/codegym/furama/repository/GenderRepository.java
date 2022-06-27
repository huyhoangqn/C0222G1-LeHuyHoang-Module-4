package com.codegym.furama.repository;


import com.codegym.furama.entity.Gender;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenderRepository extends PagingAndSortingRepository<Gender, Integer> {
}
