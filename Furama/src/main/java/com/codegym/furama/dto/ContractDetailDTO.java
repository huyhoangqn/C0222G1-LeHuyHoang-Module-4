package com.codegym.furama.dto;

public class ContractDetailDTO {
    private Integer contractDetailId;
    private Integer quantity;
    private Integer attachServiceId;
    private Integer contractId;

    public Integer getContractDetailId() {
        return this.contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAttachServiceId() {
        return this.attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public Integer getContractId() {
        return this.contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}
