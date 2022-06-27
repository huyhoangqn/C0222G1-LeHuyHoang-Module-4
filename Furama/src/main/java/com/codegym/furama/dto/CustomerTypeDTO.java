package com.codegym.furama.dto;

public class CustomerTypeDTO {
    private Integer customerTypeId;
    private String customerTypeName;

    public Integer getCustomerTypeId() {
        return this.customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return this.customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
