package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class AttachService {
    @Id
    private Integer attachServiceId;

    private String attachServiceName;
    private Double attachServiceCost;
    private Integer attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    @JsonManagedReference
    private Set<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(Integer attachServiceId, String attachServiceName, Double attachServiceCost, Integer attachServiceUnit, String attachServiceStatus, Set<com.example.demo.bean.ContractDetail> contractDetails) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetails = contractDetails;
    }
}
