package com.codegym.furama.repository;


import com.codegym.furama.dto.CustomerDTO;
import com.codegym.furama.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT new com.codegym.furama.dto.CustomerDTO(c.customerId, c.customerAddress," +
            " c.customerBirthday, c.customerEmail, c.customerIDCard, c.customerName, c.customerPhone," +
            " c.customerType.customerTypeName, c.customerGender.gender, c.deleteStatus) FROM Customer c where " +
            "c.deleteStatus =1")
    Page<CustomerDTO> findAllCustomer(Pageable pageable);

//    @Modifying
//    @Query(value = "INSERT INTO customer ( customer_id, customer_address, customer_birthday, customer_email," +
//            "customer_id_card, customer_name, customer_phone, delete_status, gender_id, customer_type_id)" +
//            " VALUES (:customer_id," +
//            " :customer_address, :customer_birthday, :customer_email, :customer_id_card, :customer_name," +
//            " :customer_phone, 1 , :gender_id, :customer_type_id);", nativeQuery = true)
//    void save(@Param("customer_id") String customerId, @Param("customer_address") String customerAddress,
//              @Param("customer_birthday") Date customerBirthday,
//              @Param("customer_email") String customerEmail, @Param("customer_id_card") Integer customerIdCard,
//              @Param("customer_name") String customerName, @Param("customer_phone") String customerPhone,
//              @Param("gender_id") Integer genderId, @Param("customer_type_id") Integer customerTypeId);


}
