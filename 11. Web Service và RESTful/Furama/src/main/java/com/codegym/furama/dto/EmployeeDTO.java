package com.codegym.furama.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private Integer employeeId;
    private String employeeAddress;
    private java.sql.Timestamp employeeBirthday;
    private String employeeEmail;
    private String employeeidcard;
    private String employeeName;
    private String employeePhone;
    private Double employeeSalary;
    private Integer divisionId;
    private Integer educationDegreeId;
    private Integer genderId;
    private Integer positionId;

}
