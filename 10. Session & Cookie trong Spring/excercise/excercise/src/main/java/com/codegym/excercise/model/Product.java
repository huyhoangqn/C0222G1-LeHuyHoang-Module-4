package com.codegym.excercise.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_Id")
    private String productId;
    @Column(name = "produdt_name")
    private String productName;
    @Column(name = "product_img_link")
    private String productImgLink;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "product_price")
    private Double productPrice;

    public Product() {
    }


}
