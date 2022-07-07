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
    @Column(name = "service_name")
    private String serviceName;

    @NotNull
    @Positive
    @Column(name = "service_area")
    private Integer serviceArea;

    @NotNull
    @Positive
    @Column(name = "service_cost")
    private Double serviceCost;

    @NotNull
    @Positive
    @Column(name = "service_max_people")
    private Integer serviceMaxPeople;
    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description_other_convenience")
    private String descriptionOtherConvenience;
    @Column(name = "pool_area")
    private Double poolArea;
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @OneToMany(mappedBy = "service")
    @JsonManagedReference
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    @JsonBackReference
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    @JsonBackReference
    private RentType rentType;

    public Service() {
    }

    public Service(String serviceId, String serviceName, Integer serviceArea, Double serviceCost, Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, Set<Contract> contracts, ServiceType serviceType, RentType rentType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.contracts = contracts;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }
}
