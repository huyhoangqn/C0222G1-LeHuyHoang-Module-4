package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Getter
@Setter
public class Service {
    @Id
    private String serviceId;

    @NotBlank
    private String serviceName;

    @NotNull
    @Positive
    private Integer serviceArea;

    @NotNull
    @Positive
    private Double serviceCost;

    @NotNull
    @Positive
    private Integer serviceMaxPeople;

    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;

    @NotBlank
    private String linkImg;

    @OneToMany(mappedBy = "service")
    @JsonManagedReference
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId")
    @JsonBackReference
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId")
    @JsonBackReference
    private RentType rentType;

    public Service() {
    }

    public Service(String serviceId, String serviceName, Integer serviceArea, Double serviceCost, Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String linkImg, Set<Contract> contracts, ServiceType serviceType, RentType rentType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.linkImg = linkImg;
        this.contracts = contracts;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

}
