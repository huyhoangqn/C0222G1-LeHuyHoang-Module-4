package com.codegym.furama.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;
    @ManyToOne
    @JoinColumn(name = "rent_type")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;

    public Service() {
    }

    public Service(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Service(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }
}
