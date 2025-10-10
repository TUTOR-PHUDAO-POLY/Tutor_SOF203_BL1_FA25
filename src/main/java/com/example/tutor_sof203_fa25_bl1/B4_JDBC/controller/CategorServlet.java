package com.example.tutor_sof203_fa25_bl1.B4_JDBC.controller;

import com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity.Category;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.service.CategoryService;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.service.impl.CategoryServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = {
        "/category/hien-thi",
        "/category/add",
        "/category/detail",
        "/category/update",
        "/category/search",
})
public class CategorServlet extends HttpServlet {

//    private CategoryRepository repo = new CategoryRepository();
//    private CategoryService cateService = new CategoryService();
    // interface = new class
    List<Category>lists = new ArrayList<>();
    ArrayList<Category>listss = new ArrayList<>();
    private CategoryService categoryService = new CategoryServiceImpl();

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

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",categoryService.getAll());
        request.getRequestDispatcher("/buoi4/index.jsp").forward(request,response);
    }

}
