package com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.controller;

import com.example.tutor_sof203_fa25_bl1.B2_CRUDListFixCung.service.DongVatService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DongVatServlet", value = {
        "/dong-vat/hien-thi-tat-ca", // GET
        "/dong-vat/search", // GET
        "/dong-vat/add", // POST
        "/dong-vat/remove", // GET
        "/dong-vat/view-update", // GET
        "/dong-vat/update" // POST
})
public class DongVatServlet extends HttpServlet {

    private DongVatService service = new DongVatService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 4 method get => viet do get
        String uri = request.getRequestURI();
        System.out.println(uri);
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
        if(uri.contains("hien-thi-tat-ca")){
            // get all
            this.hienThiDanhSachDongVat(request,response);
        }else if(uri.contains("search")){
            // search
            this.searchDongVat(request,response);
        }else if(uri.contains("view-update")){
            // detail
            this.detailDongVat(request,response);
        }else{
            // xoa
            this.xoaDongVat(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addDongVat(request,response);
        }else{
            // update
            this.updateDongVat(request,response);
        }
    }

    private void xoaDongVat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("id1");
        service.xoaDongVat(ma);
        response.sendRedirect("/dong-vat/hien-thi-tat-ca");
    }

    private void detailDongVat(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchDongVat(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDanhSachDongVat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists",service.getListDongVat());
        request.getRequestDispatcher("/buoi2/index.jsp").forward(request,response);
    }

    private void updateDongVat(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addDongVat(HttpServletRequest request, HttpServletResponse response) {
    }
}
