package com.example.tutor_sof203_fa25_bl1.B4_JDBC.repository;

import com.example.tutor_sof203_fa25_bl1.B4_JDBC.config.DBConnect;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    // CRUD
    // Get All => Select * from
    public List<Category>getAll(){
        // Logic => Get all
        List<Category> lists = new ArrayList<>();
        // Code
        // B1: Tao cau lenh SQL
        String sql ="SELECT id, category_code, category_name\n" +
                "FROM Tutor_B3.category;";
        // B2: Goi connection
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            // tao table => thu thi cau lenh sql
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category cate = new Category();
                cate.setId(rs.getLong(1));
                cate.setCategoryName(rs.getString(3));
                cate.setCategoryCode(rs.getString(2));
                lists.add(cate);
            }
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public Category getOne(Long id1){
        // B1: Tao cau lenh SQL
        String sql ="SELECT id, category_code, category_name\n" +
                "FROM Tutor_B3.category WHERE id = ?;";
        // B2: Goi connection
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setObject(1,id1);
            // tao table => thu thi cau lenh sql
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category cate = new Category();
                cate.setId(rs.getLong(1));
                cate.setCategoryName(rs.getString(3));
                cate.setCategoryCode(rs.getString(2));
                return cate;
            }
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Category cate){
        int check = 0; // chua add thanh cong
        // B1: Tao cau lenh SQL
        String sql ="INSERT INTO Tutor_B3.category\n" +
                "(id, category_code, category_name)\n" +
                "VALUES(?,?,?);";
        // B2: Goi connection
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setObject(1,cate.getId());
            ps.setObject(2,cate.getCategoryCode());
            ps.setObject(3,cate.getCategoryName());
            check = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean delete(Long id){
        int check = 0; // chua add thanh cong
        // B1: Tao cau lenh SQL
        String sql ="DELETE FROM Tutor_B3.category\n" +
                "WHERE id=?;";
        // B2: Goi connection
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setObject(1,id);
            check = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Category categoryUpdate, Long idCanUpdate){
        int check = 0; // chua add thanh cong
        // B1: Tao cau lenh SQL
        String sql ="UPDATE Tutor_B3.category\n" +
                "SET category_code= ?, category_name=?\n" +
                "WHERE id=?;";
        // B2: Goi connection
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            ps.setObject(1,categoryUpdate.getCategoryCode());
            ps.setObject(2,categoryUpdate.getCategoryName());
            ps.setObject(3,idCanUpdate);
            check = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}
