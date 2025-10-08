package com.example.tutor_sof203_fa25_bl1.B4_JDBC.controller;

import com.example.tutor_sof203_fa25_bl1.B4_JDBC.repository.CategoryRepository;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.repository.ProductRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository = new ProductRepository();

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProduct",productRepository.getAll());
        request.setAttribute("listCate",categoryRepository.getAll());
        request.getRequestDispatcher("/buoi5/product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
