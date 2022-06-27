package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gender")
@Getter
@Setter
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genderId;
    private String gender;

    @OneToMany(mappedBy = "customerGender")
    private List<Customer> customerList;

    @OneToMany(mappedBy = "employeeGender")
    private List<Employee> employeeList;

    public Gender() {
    }

    public Gender(String gender, List<Customer> customerList, List<Employee> employeeList) {
        this.gender = gender;
        this.customerList = customerList;
        this.employeeList = employeeList;
    }

    public Gender(int genderId, String gender, List<Customer> customerList) {
        this.genderId = genderId;
        this.gender = gender;
        this.customerList = customerList;
    }
}
