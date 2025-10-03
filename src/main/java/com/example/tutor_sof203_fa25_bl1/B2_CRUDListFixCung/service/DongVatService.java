package com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.service;

import com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.entity.DongVat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DongVatService {
    // Se viet cac ham xu ly logic trong service
    // table: list truyen di co bn du lieu => table co bang du lieu

    private List<DongVat> listDongVat = new ArrayList<>();
    // size = 0 => add
    // C1: Khoi tao gia tri cua list trong constructor
    // C2: static

    public DongVatService() {
        // khoi tao gia tri cua list => list.add
        listDongVat.add(new DongVat("DV01", "Dong vat 1", true, 10.5, "Ha noi"));
        listDongVat.add(new DongVat("DV02", "Dong vat 2", false, 15.5, "Vinh phuc"));
        listDongVat.add(new DongVat("DV03", "Dong vat 3", false, 13.8, "Nghe an"));
        listDongVat.add(new DongVat("DV04", "Dong vat 4", true, 20.5, "Phu tho"));
        listDongVat.add(new DongVat("DV05", "Dong vat 5", true, 33.7, "Ninh binh"));
    }

    public List<DongVat> getListDongVat() {
        return listDongVat;
    }

    public void addDongVat(DongVat dv) {
        listDongVat.add(dv);
    }

    public void xoaDongVat(String ma) {
//        for (DongVat dv : listDongVat) {
//            if (dv.getMa().equalsIgnoreCase(ma)) {
//                listDongVat.remove(dv);
//                break;
//            }
//        }
        // J8 => lamda => removeIf
        listDongVat.removeIf(dv -> dv.getMa().equalsIgnoreCase(ma));

    }

    public void updateDongVat(String maCanSua, DongVat dongVatSua) {
//        int indexUpdate = -1;
//        for(int i = 0 ; i< listDongVat.size();i++){
//            if(listDongVat.get(i).getMa().equals(maCanSua)){
//                indexUpdate = i;
//                break;
//            }
//        }
//        listDongVat.set(indexUpdate,dongVatSua);
        listDongVat.replaceAll(dv -> dv.getMa().equalsIgnoreCase(maCanSua) ? dongVatSua : dv);
    }

    public DongVat detailDongVat(String ma) {
        // C1: for each check dk
//        List<DongVat>listSearch = new ArrayList<>();
//        for (DongVat dv : listDongVat) {
//            if (dv.getMa().contains(ma)) {
//                return dv;
//                // tra ve 1 danh sach:
//                // nhieu dong => 1 list
//                // 1 dong => 1 doi tuong
////                listSearch.add(dv);
//            }
//        }
//        return null;
        // C2: filter => search
        return listDongVat.stream()
                .filter(dv -> dv.getMa().equalsIgnoreCase(ma))
//                .collect(Collectors.toCollection());
                .findFirst()
                .orElse(null);
    }

    public void sapXepDanhSachTangDanTheoMa(){
        listDongVat.sort((dv1,dv2)->dv1.getMa().compareTo(dv2.getMa()));
    }

    public List<DongVat>locDanhSachDongVatCoCanNangNho50(){
        return listDongVat.stream()
                .filter(dv -> dv.getCanNang() < 50)
                .collect(Collectors.toList());
    }

    // dong vat 2  va Dong vat 2 => dong vat 2
    // dong Vat => dong vat 2
    public List<DongVat>search(String searchValue, Double canNangMin, Double canNangMax){
        String keyword = (searchValue == null) ?"": searchValue.trim().toLowerCase();

        return listDongVat.stream()
                .filter( dv ->
                        // loc theo ma va ten
                        (keyword.isEmpty() || (dv.getMa() !=null && dv.getMa().toLowerCase().contains(keyword))
                                || (dv.getTen() !=null && dv.getTen().toLowerCase().contains(keyword)))
                        // loc theo can nang min & max
                        && (canNangMin == null || ( dv.getCanNang() >=canNangMin))
                        && (canNangMax == null || ( dv.getCanNang() <=canNangMax))
                )
                .collect(Collectors.toList());
    }
}
