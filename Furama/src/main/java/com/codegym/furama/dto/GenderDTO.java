package com.codegym.furama.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenderDTO {
    private Integer genderId;
    private String gender;

    public GenderDTO(Integer genderId, String gender) {
        this.genderId = genderId;
        this.gender = gender;
    }

    public GenderDTO() {
    }
}
