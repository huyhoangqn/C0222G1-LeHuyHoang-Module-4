package com.codegym.furama.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
public class CustomerDTO {
    @Pattern(regexp = "^(KH-)[\\d]{4}$", message = "The customer ID has the format KH-XXXX (X : 0-9)")
    @NotBlank(message = "ID cannot be empty!!")
    private String customerId;

    @NotBlank(message = "Name cannot be empty!!")
    private String customerName;

    @Past(message = "Invalid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date customerBirthday;

    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$", message = "IDcard invalid")
    @NotBlank(message = "ID card cannot be empty!!")
    private String customerIDCard;

    @Pattern(regexp = "^((\\(84\\)\\+)|(0))((91)|(90)|(84)|(85)|(93)|(94)|(96)|(38)|(88)|(39))[\\d]{7}$",
            message = "Invalid phone number")
    @NotBlank(message = "Phone number cannot be empty!")
    private String customerPhone;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email")
    @NotBlank(message = "Email cannot be empty!!")
    private String customerEmail;

    @NotBlank(message = "Address cannot be empty!!")
    private String customerAddress;

    private Integer deleteStatus;

    private String customerTypeName;
    private Integer customerTypeId;


    private String genderName;
    private Integer genderId;

    private CustomerTypeDTO customerTypeDTO;

    private GenderDTO genderDTO;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerId, String customerAddress, Date customerBirthday, String customerEmail,
                       String customerIDCard, String customerName, String customerPhone, String customerTypeName, String genderName, Integer deleteStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerIDCard = customerIDCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.deleteStatus = deleteStatus;
        this.customerTypeName = customerTypeName;
        this.genderName = genderName;
    }

    public CustomerDTO(String customerId, String customerAddress, Date customerBirthday, String customerEmail,
                       String customerIDCard, String customerName, String customerPhone, Integer customerTypeId, Integer genderId, CustomerTypeDTO customerTypeDTO, GenderDTO genderDTO) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerIDCard = customerIDCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerTypeDTO = customerTypeDTO;
        this.genderDTO = genderDTO;
    }
}
