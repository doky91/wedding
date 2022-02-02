package com.weddingplanner.services.interfaces;

import com.weddingplanner.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategory();

    Category getCategory(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category input);

    void deleteCategory(Long id);
}
