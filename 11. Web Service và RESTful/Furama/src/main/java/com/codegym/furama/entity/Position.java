package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;

    public Position() {
    }

    public Position(String positionName, List<Employee> employeeList) {
        this.positionName = positionName;
        this.employeeList = employeeList;
    }

    public Position(int positionId, String positionName, List<Employee> employeeList) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employeeList = employeeList;
    }
}
