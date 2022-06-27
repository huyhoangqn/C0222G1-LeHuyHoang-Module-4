package com.codegym.furama.repository;


import com.codegym.furama.entity.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {
}
