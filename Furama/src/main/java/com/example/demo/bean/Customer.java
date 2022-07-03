package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    private String customerId;

    @NotBlank
    private String customerName;

    @NotEmpty
    private String customerBirthday;
    @Column(name = "gender_id")
    private Integer customerGender;

    @NotBlank
    @Pattern(regexp = "^[0-9]{9}$", message = "The Id Card must have 9 digits and be in the format XXX XXX XXX.")
    private String customerIdCard;

    @NotBlank
    @Pattern(regexp = "^((091)|(090))[0-9]{7}$", message = "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.")
    private String customerPhone;

    @NotBlank
    @Email
    private String customerEmail;

    @NotBlank
    private String customerAddress;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "customerTypeId")
    @JsonBackReference
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerBirthday, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, Set<com.example.demo.bean.Contract> contracts, com.example.demo.bean.CustomerType customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.contracts = contracts;
        this.customerType = customerType;
    }
}
