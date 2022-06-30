package com.codegym.furama.repository;


import com.codegym.furama.dto.CustomerTypeDTO;
import com.codegym.furama.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    @Query(value = "SELECT new com.codegym.furama.dto.CustomerTypeDTO(c.customerTypeId, c.customerTypeName) FROM CustomerType c")
    List<CustomerTypeDTO> findAllCustomerType();
}
