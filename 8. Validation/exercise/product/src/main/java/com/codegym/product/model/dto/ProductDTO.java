package com.codegym.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String description;
    private String manufacturer;
    private String name;
    private String price;
    private Integer status;

    public ProductDTO(Integer id, String description, String manufacturer, String name, String price, Integer status) {
        this.id = id;
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public ProductDTO() {

    }
}
