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
public class Category {
    // liet ke cac thuoc tinh co trong SQL bang tuong ung (Category)
//    id BIGINT IDENTITY NOT NULL,
//    category_code varchar(100) NULL,
//    category_name Nvarchar(100) NULL
    private Long id;

    private String categoryCode;

    private String categoryName;

}
