package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    private String employeeId;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_birthday")
    private String birthday;
    @Column(name = "employee_id_card")
    private String idCard;
    @Column(name = "employee_salary")
    private Double salary;
    @Column(name = "employee_phone")
    private String phone;
    @Column(name = "employee_email")
    private String email;
    @Column(name = "employee_address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "positionId", nullable = false, referencedColumnName = "positionId")
    @JsonBackReference
    private Position position;

    @ManyToOne
    @JoinColumn(name = "educationDegreeId", nullable = false, referencedColumnName = "educationDegreeId")
    @JsonBackReference
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "divisionId", nullable = false, referencedColumnName = "divisionId")
    @JsonBackReference
    private Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(String employeeId, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, User user) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
    }

    public Employee(String employeeId, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, User user, Set<Contract> contracts) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }
}
