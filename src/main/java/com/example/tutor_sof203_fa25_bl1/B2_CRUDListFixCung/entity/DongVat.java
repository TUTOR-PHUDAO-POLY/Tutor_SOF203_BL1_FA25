package com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DongVat {

    private String ma;

    private String ten;

    private boolean gioiTinh;

    private double canNang;

    private String khuVucSong;

}
