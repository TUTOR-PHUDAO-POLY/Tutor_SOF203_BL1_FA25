package com.example.tutor_sof203_fa25_bl1.B4_JDBC.service.impl;

import com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity.Category;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.service.CategoryService;

import java.util.List;

public class TestSeriveImpl implements CategoryService {
    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Category detailCategory(Long id) {
        return null;
    }

    @Override
    public void addCate(Category cate) {

    }

    @Override
    public void updateCate(Category cate, Long idCanUpdate) {

    }

    @Override
    public void deleteCate(Long id) {

    }

    @Override
    public List<Category> search(String name) {
        return null;
    }

    @Override
    public List<Category> sapXepTangDan() {
        return null;
    }
}
