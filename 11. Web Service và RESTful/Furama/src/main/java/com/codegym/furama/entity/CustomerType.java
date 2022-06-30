package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
@Getter
@Setter
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;
    //    @JsonIgnore
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerTypeName, List<Customer> customerList) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.customerList = customerList;
    }

    public CustomerType(String customerTypeName, List<Customer> customerList) {
        this.customerTypeName = customerTypeName;
        this.customerList = customerList;
    }

}
