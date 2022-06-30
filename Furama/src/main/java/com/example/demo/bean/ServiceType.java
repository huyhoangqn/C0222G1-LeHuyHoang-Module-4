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
public class ServiceType {

    @Id
    private Integer serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    @JsonManagedReference
    private Set<com.example.demo.bean.Service> services;

    public ServiceType() {
    }

    public ServiceType(Integer serviceTypeId, String serviceTypeName, Set<com.example.demo.bean.Service> services) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }
}
