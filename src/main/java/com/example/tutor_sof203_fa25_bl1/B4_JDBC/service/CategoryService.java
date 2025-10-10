package com.example.tutor_sof203_fa25_bl1.B4_JDBC.service;

import com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity.Category;

import java.util.List;

public interface CategoryService {
    // liet ke cac chuc nang can lam
    // ham trong interface khong code body code
    // ham trong interface luon luon la public
    List<Category>getAll();

    Category detailCategory(Long id);

    void addCate(Category cate);

    void updateCate(Category cate, Long idCanUpdate);

    void deleteCate(Long id);

    List<Category>search(String name);

    List<Category>sapXepTangDan();

}
