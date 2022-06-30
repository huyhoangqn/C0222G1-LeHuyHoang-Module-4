package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
@Getter
@Setter
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractDetailId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(int quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public ContractDetail(int contractDetailId, int quantity, AttachService attachService, Contract contract) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }
}
