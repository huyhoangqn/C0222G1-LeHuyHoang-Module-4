package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contract")
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private String contractStartDate;
    private String contractEndDate;
    private double contractDeposite;
    private double contractTotalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;
    public Contract() {
    }

    public Contract(String contractStartDate, String contractEndDate, double contractDeposite, double contractTotalMoney, Employee employee, Customer customer, Service service) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposite = contractDeposite;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Contract(int contractId, String contractStartDate, String contractEndDate, double contractDeposite, double contractTotalMoney, Employee employee, Customer customer, Service service) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposite = contractDeposite;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

}
