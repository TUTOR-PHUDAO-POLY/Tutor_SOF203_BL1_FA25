package com.example.tutor_sof203_fa25_bl1.B4_JDBC.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CategorServlet", value = {
        "/category/hien-thi",
        "/category/add",
        "/category/detail",
        "/category/update",
        "/category/search",
})
public class CategorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.hienThiCategory(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) {
    }

}
