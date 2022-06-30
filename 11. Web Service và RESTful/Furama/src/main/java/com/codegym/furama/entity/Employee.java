package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @NotBlank(message = "Not Blank!")
    private String employeeName;
    @Past(message = "Invalid")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;
    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$", message = "Invalid")
    @NotBlank(message = "Not blank!")
    private String employeeIDCard;
    @NotNull(message = "Not blank!")
    @DecimalMin(value = "0.0", message = "Must be greater than 0")
    private double employeeSalary;
    @Pattern(regexp = "^((\\(84\\)\\+)|(0))((91)|(90)|(84)|(85)|(93)|(94)|(96)|(38))[\\d]{7}$", message = "Invalid phone number")
    @NotBlank(message = "Not blank!")
    private String employeePhone;
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email")
    @NotBlank(message = "Not blank!")
    private String employeeEmail;
    @NotBlank(message = "Not blank!")
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender employeeGender;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(String employeeName, Date employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public Employee(int employeeId, String employeeName, Date employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }
}
