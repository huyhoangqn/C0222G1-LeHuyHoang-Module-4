package com.codegym.furama.dto;

public class RentTypeDTO {
    private Integer rentTypeId;
    private Double serviceTypeCost;
    private String serviceTypeName;

    public Integer getRentTypeId() {
        return this.rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public Double getServiceTypeCost() {
        return this.serviceTypeCost;
    }

    public void setServiceTypeCost(Double serviceTypeCost) {
        this.serviceTypeCost = serviceTypeCost;
    }

    public String getServiceTypeName() {
        return this.serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
