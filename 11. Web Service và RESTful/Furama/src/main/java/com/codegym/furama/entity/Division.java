package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "division")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division")
    private List<Employee> employeeList;

    public Division() {
    }

    public Division(String division_name, List<Employee> employeeList) {
        this.divisionName = division_name;
        this.employeeList = employeeList;
    }

    public Division(int divisionId, String divisionName, List<Employee> employeeList) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employeeList = employeeList;
    }
}
