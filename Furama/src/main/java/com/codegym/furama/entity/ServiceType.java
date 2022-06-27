package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
@Getter
@Setter
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private List<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(String serviceTypeName, List<Service> serviceList) {
        this.serviceTypeName = serviceTypeName;
        this.serviceList = serviceList;
    }

    public ServiceType(int serviceTypeId, String serviceTypeName, List<Service> serviceList) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.serviceList = serviceList;
    }

}
