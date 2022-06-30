package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
@Getter
@Setter
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeId, String educationDegreeName, List<Employee> employeeList) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.employeeList = employeeList;
    }

    public EducationDegree(String educationDegreeName, List<Employee> employeeList) {
        this.educationDegreeName = educationDegreeName;
        this.employeeList = employeeList;
    }

}
