package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    private String employeeId;

    private String name;
    private String birthday;
    private String idCard;
    private Double salary;
    private String phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "positionId",nullable = false,referencedColumnName = "positionId")
    @JsonBackReference
    private com.example.demo.bean.Position position;

    @ManyToOne
    @JoinColumn(name = "educationDegreeId",nullable = false,referencedColumnName = "educationDegreeId")
    @JsonBackReference
    private com.example.demo.bean.EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "divisionId",nullable = false,referencedColumnName = "divisionId")
    @JsonBackReference
    private com.example.demo.bean.Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    @JsonManagedReference
    private com.example.demo.bean.User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<com.example.demo.bean.Contract> contracts;

    public Employee() {
    }

    public Employee(String employeeId, String name, String birthday, String idCard, Double salary, String phone, String email, String address, com.example.demo.bean.Position position, com.example.demo.bean.EducationDegree educationDegree, com.example.demo.bean.Division division, com.example.demo.bean.User user) {
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

    public Employee(String employeeId, String name, String birthday, String idCard, Double salary, String phone, String email, String address, com.example.demo.bean.Position position, com.example.demo.bean.EducationDegree educationDegree, com.example.demo.bean.Division division, com.example.demo.bean.User user, Set<com.example.demo.bean.Contract> contracts) {
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public com.example.demo.bean.Position getPosition() {
        return position;
    }

    public void setPosition(com.example.demo.bean.Position position) {
        this.position = position;
    }

    public com.example.demo.bean.EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(com.example.demo.bean.EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public com.example.demo.bean.Division getDivision() {
        return division;
    }

    public void setDivision(com.example.demo.bean.Division division) {
        this.division = division;
    }

    public com.example.demo.bean.User getUser() {
        return user;
    }

    public void setUser(com.example.demo.bean.User user) {
        this.user = user;
    }

    public Set<com.example.demo.bean.Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<com.example.demo.bean.Contract> contracts) {
        this.contracts = contracts;
    }
}
