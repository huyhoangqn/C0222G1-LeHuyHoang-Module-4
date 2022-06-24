package com.codegym.product2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class ProductDTO implements Validator {
    private Integer id;
    @NotEmpty(message = "Khong duoc de trong")
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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        if (productDTO.description.matches("^$")) {
            errors.rejectValue("description", "description.EmptyString");
        } else if (!productDTO.description.matches("^[A-Z a-z]{2,10}$")) {
            errors.rejectValue("description", "description.invalidFormat");
        }

        if (productDTO.manufacturer.matches("^$")) {
            errors.rejectValue("manufacturer", "manufacturer.EmptyString");
        } else if (!productDTO.manufacturer.matches("^[A-Z a-z]{2,10}$")) {
            errors.rejectValue("manufacturer", "manufacturer.invalidFormat");
        }

        if (productDTO.name.matches("^$")) {
            errors.rejectValue("name", "name.EmptyString");
        } else if (!productDTO.name.matches("^(84|0[3|5|7|8|9])+([0-9]{8})$")) {
            errors.rejectValue("name", "name.invalidFormat");
        }

        if (productDTO.price.matches("^$")) {
            errors.rejectValue("price", "price.EmptyString");
        } else if (!productDTO.price.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.rejectValue("price", "price.invalidFormat");
        }
    }
}
