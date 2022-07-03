package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class EmployeeUser {
    private String employeeId;

    @NotBlank
    private String name;

    @NotBlank
    private String birthday;

    @NotBlank
    @Pattern(regexp = "^[0-9]{9}$", message = "The Id Card must have 9 digits and be in the format XXX XXX XXX.")
    private String idCard;

    @NotNull
    @Positive
    private Double salary;

    @NotBlank
    @Pattern(regexp = "^((091)|(090))[0-9]{7}$", message = "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.")
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    @NotBlank
    @Size(min = 5, max = 15)
    private String userName;

    @NotBlank
    @Size(min = 5, max = 15)
    private String passWord;

    public EmployeeUser() {
    }

    public EmployeeUser(String employeeId, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, String userName, String passWord) {
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
        this.userName = userName;
        this.passWord = passWord;
    }
}
