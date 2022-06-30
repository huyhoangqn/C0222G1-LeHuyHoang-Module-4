package com.example.demo.repository;


import com.example.demo.dto.CustomerTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    @Query(value = "SELECT new com.example.demo.dto.CustomerTypeDTO(c.customerTypeId, c.customerTypeName) FROM CustomerType c")
    List<CustomerTypeDTO> findAllCustomerType();
}
