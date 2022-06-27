package com.codegym.furama.dto;

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

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeAddress() {
        return this.employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public java.sql.Timestamp getEmployeeBirthday() {
        return this.employeeBirthday;
    }

    public void setEmployeeBirthday(java.sql.Timestamp employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeidcard() {
        return this.employeeidcard;
    }

    public void setEmployeeidcard(String employeeidcard) {
        this.employeeidcard = employeeidcard;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return this.employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Double getEmployeeSalary() {
        return this.employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Integer getDivisionId() {
        return this.divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public Integer getEducationDegreeId() {
        return this.educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Integer getGenderId() {
        return this.genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getPositionId() {
        return this.positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
