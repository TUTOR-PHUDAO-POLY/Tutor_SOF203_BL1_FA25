package com.example.tutor_sof203_fa25_bl1.B4_JDBC.repository;

import com.example.tutor_sof203_fa25_bl1.B4_JDBC.config.DBConnect;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity.Category;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private CategoryRepository cateRepo = new CategoryRepository();
    // get All
    public List<Product> getAll(){
        // Logic => Get all
        List<Product> lists = new ArrayList<>();
        // Code
        // B1: Tao cau lenh SQL
        String sql ="SELECT p.id as 'Product ID', c.id as 'Category ID', p.product_code,p.product_name,p.price,c.category_code,c.category_name,p.[description]\n" +
                "FROM category c JOIN product p \n" +
                "ON c.id = p.category_id ";
        // B2: Goi connection
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            // tao table => thu thi cau lenh sql
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Product p = new Product();
                p.setId(rs.getLong(1));
                p.setDescription(rs.getString(8));
                p.setProductCode(rs.getString(3));
                p.setProductName(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                // Category
                Category cate = new Category();
                cate.setId(rs.getLong(2));
                // getOne
//                Category cate = cateRepo.getOne(rs.getLong(2));
                cate.setCategoryName(rs.getString(7));
                cate.setCategoryCode(rs.getString(6));
                // set cate vao product
                p.setCate(cate);
                // add p vao list
                lists.add(p);
            }
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new ProductRepository().getAll());
    }
}
