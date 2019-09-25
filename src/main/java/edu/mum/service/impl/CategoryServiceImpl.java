package edu.mum.service.impl;

import edu.mum.dao.CategoryDao;
import edu.mum.domain.Category;
import edu.mum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.findOne(id);
    }
}
