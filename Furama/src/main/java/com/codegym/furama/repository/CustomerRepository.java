package com.codegym.furama.repository;


import com.codegym.furama.dto.CustomerDTO;
import com.codegym.furama.dto.CustomerTypeDTO;
import com.codegym.furama.dto.GenderDTO;
import com.codegym.furama.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT new com.codegym.furama.dto.CustomerDTO(c.customerId, c.customerAddress, c.customerBirthday, c.customerEmail, c.customerIDCard, c.customerName, c.customerPhone, c.deleteStatus, new com.codegym.furama.dto.GenderDTO(c.customerGender)) FROM Customer c where c.deleteStatus =1")
    Page<CustomerDTO> findAllCustomer(Pageable pageable);
}
