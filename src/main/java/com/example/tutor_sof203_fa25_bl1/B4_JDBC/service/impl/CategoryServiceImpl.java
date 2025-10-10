package com.example.tutor_sof203_fa25_bl1.B4_JDBC.service.impl;

import com.example.tutor_sof203_fa25_bl1.B4_JDBC.entity.Category;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.repository.CategoryRepository;
import com.example.tutor_sof203_fa25_bl1.B4_JDBC.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository cateRepo = new CategoryRepository();

    @Override
    public List<Category> getAll() {
        return cateRepo.getAll();
    }

    @Override
    public Category detailCategory(Long id) {
        return cateRepo.getOne(id);
    }

    @Override
    public void addCate(Category cate) {
        cateRepo.add(cate);
    }

    @Override
    public void updateCate(Category cate, Long idCanUpdate) {
        cateRepo.update(cate, idCanUpdate);
    }

    @Override
    public void deleteCate(Long id) {
        cateRepo.delete(id);
    }

    @Override
    public List<Category> search(String name) {
        return cateRepo.searchByName(name);
    }

    @Override
    public List<Category> sapXepTangDan() {
        return cateRepo.sapXepGianDanTheoTen();
    }
}
