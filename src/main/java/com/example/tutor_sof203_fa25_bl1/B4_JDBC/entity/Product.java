package com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    // Mapping nhu binh thuong

    private Long id;

    private String productCode;

    private String productName;

    private String description;

    private double price;

    // khoa ngoai => k nen mapping nhu thuoc tinh binh thuong
    private Category cate;

}
