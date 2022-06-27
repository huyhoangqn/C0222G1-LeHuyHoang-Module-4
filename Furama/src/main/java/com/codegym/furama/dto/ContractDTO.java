package com.codegym.furama.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDTO {
    private Integer contractId;
    private Double contractDeposite;
    private String contractEndDate;
    private String contractStartDate;
    private Double contractTotalMoney;
    private String customerId;
    private Integer employeeId;
    private Integer serviceId;
}
