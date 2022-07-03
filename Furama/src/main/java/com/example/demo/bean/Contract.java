package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractId;

    @NotBlank
    @Column(name = "contract_start_date")
    private String contractStartDate;

    @NotBlank
    @Column(name = "contract_end_date")
    private String contractEndDate;

    @NotNull
    @Positive
    @Column(name = "contract_deposite")
    private Double contractDeposit;
    @Column(name = "contract_total_money")
    private Double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    @JsonBackReference
    private Employee employee;

    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private Set<ContractDetail> contractDetails;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    @JsonBackReference
    private Service service;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @JsonBackReference
    private Customer customer;

    public Contract() {
    }

    public Contract(Integer contractId, String contractStartDate, String contractEndDate, Double contractDeposit, Double contractTotalMoney, Employee employee, Set<ContractDetail> contractDetails, com.example.demo.bean.Service service, Customer customer) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.contractDetails = contractDetails;
        this.service = service;
        this.customer = customer;
    }

    public Contract(Integer contractId, String contractStartDate, String contractEndDate, Double contractDeposit, Employee employee, Service service, Customer customer) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.employee = employee;
        this.service = service;
        this.customer = customer;
    }
}
