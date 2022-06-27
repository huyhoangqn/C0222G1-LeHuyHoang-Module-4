package com.codegym.furama.dto;

public class ContractDTO {
    private Integer contractId;
    private Double contractDeposite;
    private String contractEndDate;
    private String contractStartDate;
    private Double contractTotalMoney;
    private String customerId;
    private Integer employeeId;
    private Integer serviceId;

    public Integer getContractId() {
        return this.contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Double getContractDeposite() {
        return this.contractDeposite;
    }

    public void setContractDeposite(Double contractDeposite) {
        this.contractDeposite = contractDeposite;
    }

    public String getContractEndDate() {
        return this.contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractStartDate() {
        return this.contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Double getContractTotalMoney() {
        return this.contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
