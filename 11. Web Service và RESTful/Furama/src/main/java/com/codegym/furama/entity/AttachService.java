package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_service")
@Getter
@Setter
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachServiceId;
    private String attachServiceName;
    private double attachServiceCost;
    private int attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    private List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(String attachServiceName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus, List<ContractDetail> contractDetails) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetails = contractDetails;
    }

    public AttachService(int attachServiceId, String attachServiceName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus, List<ContractDetail> contractDetails) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetails = contractDetails;
    }

}
