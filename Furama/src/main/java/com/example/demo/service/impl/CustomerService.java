package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.DuplicateIDException;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<CustomerDTO> findAllCustomer(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

//    @Override
//    public Customer create(Customer customer) throws DuplicateIDException {
//        try {
//            customerRepository.save(customer);
//            return customer;
//        } catch (DataIntegrityViolationException e) {
//            throw new DuplicateIDException();
//        }
//    }

    @Override
    public Customer edit(Customer customer) throws DuplicateIDException {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer remove(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customerRepository.deleteById(id);
        return customer;
    }

    @Override
    public boolean existId(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable) {
//        return customerRepository.findAllByCustomerNameContaining(name, pageable);
        return null;
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setCustomerBirthday(customerDTO.getCustomerBirthday());
        customer.setCustomerEmail(customerDTO.getCustomerEmail());
        customer.setCustomerIDCard(customerDTO.getCustomerIDCard());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerPhone(customerDTO.getCustomerPhone());
        customer.setDeleteStatus(1);
        customer.setCustomerGenderId(customerDTO.getCustomerTypeDTO().getCustomerTypeId());
        customer.setCustomerGenderId(customerDTO.getCustomerTypeDTO().getCustomerTypeId());
        customerRepository.save(customer);
    }
}
