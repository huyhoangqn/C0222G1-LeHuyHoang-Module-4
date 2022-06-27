package com.codegym.furama.dto;

public class CustomerDTO {
    private String customerId;
    private String customerAddress;
    private java.sql.Date customerBirthday;
    private String customerEmail;
    private String customerIdCard;
    private String customerName;
    private String customerPhone;
    private Integer genderId;
    private Integer customerTypeId;
    private String customeridcard;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerAddress() {
        return this.customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public java.sql.Date getCustomerBirthday() {
        return this.customerBirthday;
    }

    public void setCustomerBirthday(java.sql.Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerIdCard() {
        return this.customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return this.customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getGenderId() {
        return this.genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getCustomerTypeId() {
        return this.customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomeridcard() {
        return this.customeridcard;
    }

    public void setCustomeridcard(String customeridcard) {
        this.customeridcard = customeridcard;
    }
}
