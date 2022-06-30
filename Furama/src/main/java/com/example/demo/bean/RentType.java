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
public class RentType {
    @Id
    private Integer rentTypeId;
    private String rentTypeName;
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    @JsonManagedReference
    private Set<Service> services;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, Double rentTypeCost, Set<com.example.demo.bean.Service> services) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.services = services;
    }
}
