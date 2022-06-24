package com.codegym.product.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private Integer id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "description")
    private String description;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "status")
    private Integer status;
}
