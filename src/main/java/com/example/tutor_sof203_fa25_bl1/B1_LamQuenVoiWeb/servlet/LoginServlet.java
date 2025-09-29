package com.example.tutor_sof203_fa25_bl1.B1_LamQuenVoiWeb.servlet;

import com.example.tutor_sof203_fa25_bl1.B1_LamQuenVoiWeb.request.LoginRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {
        // liet ke cac duong dan theo yeu cau cua de bai
        // Duong dan bat dau bang dau /
        // Duong dan la duy nhat => cua toan bo project
        "/login",
        "/ket-qua"
        // control duplicate
})
public class LoginServlet extends HttpServlet {

    // J3: JSP <=> Servlet
    // Giao dien <=> Java(logic)
    // html <=> Spring Boot - J5
    // VueJS/ReactJS/Angular... - FW cua FE (JS +)     <=> Spring boot
    // FE <=> BE: http method: GET, POST, PUT, DELETE, PATCH...
    // 404, 403... => http status code
    // J3, J4, J5: 2 phuong: GET & POST
    // GET: dung de hien thi/ lay ra
    // POST: xu ly form & Che giau thong tin

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // hien thi ra trang jsp login
        // C1: request.getRequestDispatcher.
        // => Duong dan hien thi:/login(servlet)
        // Truyen du lieu tu servlet -> jsp
//        String mess = "Tutor SOF203";
//        request.setAttribute("mess1","Tutor SOF203");
//        request.getRequestDispatcher("/buoi1/login.jsp").forward(request,response);
        // C2: response.sendRedirect
        // Chuyen sang trang gi ?
        // Khong mang du lieu di
        request.setAttribute("mess1","Tutor SOF203");
        response.sendRedirect("/buoi1/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri vua nhap tren trinh duyet
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
//        String password1 = request.getParameter("pass");
//        String password2 = request.getParameter("pass");
//        String password3 = request.getParameter("pass");
        // Validate (neu co)
        // 1. yeu cau check trong
        // 2. Yeu cau tai khoan bat buoc phai la HangNT169 & 123456. => Tai khoan k hop le
        String error = "";
        if(username.isBlank() || password.isBlank()){
            error = "Username hoặc mật khẩu không để trống";
            request.setAttribute("error",error);
            // B3: Chuyen trang
            request.getRequestDispatcher("/buoi1/login.jsp").forward(request,response);
        } else if(!username.equalsIgnoreCase("HangNT169") && !password.equals("123456")){
            error = "Tài khoản không hợp lệ";
            request.setAttribute("error",error);
            // B3: Chuyen trang
            request.getRequestDispatcher("/buoi1/login.jsp").forward(request,response);
        }else{
            // B2: Set gia tri sang jsp moi
            LoginRequest loginRequest = new LoginRequest(username,password);
            request.setAttribute("loginRequest",loginRequest);
            // B3: Chuyen trang
            request.getRequestDispatcher("/buoi1/ket-qua.jsp").forward(request,response);
        }

    }
}
