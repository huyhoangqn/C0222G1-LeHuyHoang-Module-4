package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id

    @Column(name = "customer_id")
    private String customerId;


    @Column(name = "customer_name")
    private String customerName;


    @Column(name = "customer_birthday")
    private Date customerBirthday;


    @Column(name = "customer_id_card")
    private String customerIDCard;

    @Column(name = "customer_phone")

    private String customerPhone;


    @Column(name = "customer_email")
    private String customerEmail;


    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "delete_status")
    private Integer deleteStatus;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender customerGender;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {
    }

}
