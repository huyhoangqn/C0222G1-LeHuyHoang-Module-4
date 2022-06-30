package com.codegym.furama.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private Integer serviceId;
    private String descriptionOtherConvenience;
    private Integer numberOfFloors;
    private Double poolArea;
    private Integer serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private String serviceName;
    private String standardRoom;
    private Integer rentType;
    private Integer serviceType;
}
