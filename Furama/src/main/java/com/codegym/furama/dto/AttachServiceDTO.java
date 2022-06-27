package com.codegym.furama.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachServiceDTO {
    private Integer attachServiceId;
    private Double attachServiceCost;
    private String attachServiceName;
    private String attachServiceStatus;
    private Integer attachServiceUnit;
}
