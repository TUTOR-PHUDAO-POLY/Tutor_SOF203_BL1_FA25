package com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.controller;

import com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.entity.DongVat;
import com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.service.DongVatService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "DongVatServlet", value = {
        "/dong-vat/hien-thi-tat-ca", // GET
        "/dong-vat/search", // GET
        "/dong-vat/add", // POST
        "/dong-vat/remove", // GET
        "/dong-vat/view-update", // GET
        "/dong-vat/update", // POST
        "/dong-vat/detail", // GET
        "/dong-vat/sort", // GET
        "/dong-vat/filter", // GET
})
public class DongVatServlet extends HttpServlet {

    private DongVatService service = new DongVatService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 4 method get => viet do get
        String uri = request.getRequestURI();
//        https://viblo.asia/p/su-dung-streams-filter-trong-java-8-naQZReedKvx
//        http://localhost:8080/dong-vat/search => url
        // http:
        // localhost => tomcat server: 127.
        // 8080: port - 2/4 (8080: port default -> website)
        // path -> application context=> nen xoa
        // uri
//        switch (uri){
//            case "/dong-vat/hien-thi-tat-ca":{
//
//            }
//        }
        if (uri.contains("hien-thi-tat-ca")) {
            // get all
            this.hienThiDanhSachDongVat(request, response);
        } else if (uri.contains("search")) {
            // search
            this.searchDongVat(request, response);
        } else if (uri.contains("view-update")) {
            // detail
            this.viewUpdate(request, response);
        } else if (uri.contains("detail")) {
            this.detailDongVat(request, response);
        } else if (uri.contains("sort")) {
            this.sort(request, response);
        } else if (uri.contains("filter")) {
            this.filter(request, response);
        } else {
            // xoa
            this.xoaDongVat(request, response);
        }
    }

    private void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists", service.locDanhSachDongVatCoCanNangNho50());
        request.getRequestDispatcher("/buoi2/index.jsp").forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service.sapXepDanhSachTangDanTheoMa();
        request.setAttribute("lists", service.getListDongVat());
        request.getRequestDispatcher("/buoi2/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addDongVat(request, response);
        } else {
            // update
            this.updateDongVat(request, response);
        }
    }

    private void xoaDongVat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("id1");
        service.xoaDongVat(ma);
        response.sendRedirect("/dong-vat/hien-thi-tat-ca");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("id2");
        request.setAttribute("dv1", service.detailDongVat(ma));
        request.getRequestDispatcher("/buoi2/update.jsp").forward(request, response);
    }

    private void detailDongVat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("id2");
        request.setAttribute("dv1", service.detailDongVat(ma));
        request.setAttribute("lists", service.getListDongVat());
        request.getRequestDispatcher("/buoi2/index.jsp").forward(request, response);
    }

    private void searchDongVat(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDanhSachDongVat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists", service.getListDongVat());
        request.getRequestDispatcher("/buoi2/index.jsp").forward(request, response);
    }

    @SneakyThrows
    private void updateDongVat(HttpServletRequest request, HttpServletResponse response) {
        // B1: Lay ra duoc doi tuong can update
        String ma = request.getParameter("ma1");
        DongVat dv = service.detailDongVat(ma);
        // B2: Goi ham update
        BeanUtils.populate(dv, request.getParameterMap());
        service.updateDongVat(ma, dv);
        // B3: Quay ve trang hien thi
        response.sendRedirect("/dong-vat/hien-thi-tat-ca");
    }

    @SneakyThrows
    private void addDongVat(HttpServletRequest request, HttpServletResponse response) {
        // B1: tao ra 1 đối tượng động vật
        DongVat dv = new DongVat();
        // B2: Lay toan bo thong tin tu form add trong jsp
//        dv.setTen(request.getParameter("ten"));
//        dv.setMa(request.getParameter("ten"));
//        dv.setGioiTinh(request.getParameter("ten"));
//        dv.setCanNang(request.getParameter("ten"));
//        dv.setKhuVucSong(request.getParameter("ten"));
        // name input phan trung vs name trong Object - thuoc tinh
        BeanUtils.populate(dv, request.getParameterMap());
        // B3: goi ham add trong service
        service.addDongVat(dv);
        // B4: quay ve trang ban dau
        response.sendRedirect("/dong-vat/hien-thi-tat-ca");
    }
}
