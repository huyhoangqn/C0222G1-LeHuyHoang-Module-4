package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
@Getter
@Setter
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractDetailId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "contractId")
    @JsonBackReference
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attachServiceId")
    @JsonBackReference
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractDetailId, Integer quantity, com.example.demo.bean.Contract contract, AttachService attachService) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }
}
