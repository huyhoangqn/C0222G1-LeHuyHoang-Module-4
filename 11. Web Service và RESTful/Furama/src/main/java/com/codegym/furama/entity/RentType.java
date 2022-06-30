package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
@Getter
@Setter
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;
    private String serviceTypeName;
    private double serviceTypeCost;

    @OneToMany(mappedBy = "rentType")
    private List<Service> serviceList;

    public RentType() {
    }

    public RentType(String serviceTypeName, double serviceTypeCost, List<Service> serviceList) {
        this.serviceTypeName = serviceTypeName;
        this.serviceTypeCost = serviceTypeCost;
        this.serviceList = serviceList;
    }

    public RentType(int rentTypeId, String serviceTypeName, double serviceTypeCost, List<Service> serviceList) {
        this.rentTypeId = rentTypeId;
        this.serviceTypeName = serviceTypeName;
        this.serviceTypeCost = serviceTypeCost;
        this.serviceList = serviceList;
    }

}
