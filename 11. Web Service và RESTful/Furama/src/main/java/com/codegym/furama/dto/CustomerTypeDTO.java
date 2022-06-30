package com.codegym.furama.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerTypeDTO {
    private Integer customerTypeId;
    private String customerTypeName;

    public CustomerTypeDTO(Integer customerTypeId, String customerTypeName) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }
}
