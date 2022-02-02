package com.weddingplanner.services;

import com.weddingplanner.entity.Category;
import com.weddingplanner.exceptions.DataFailedException;
import com.weddingplanner.repositories.CategoryRepository;
import com.weddingplanner.services.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BasicServiceOperations implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(itemNotFound("Category with id: " + id + " does not exist"));
    }

    @Override
    public Category createCategory(Category category) {
        if (doesNameExist(category.getName())) {
            throw new DataFailedException(
                    CONFLICT, "Offer name:" + category.getName() + "already exists in database.");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category input) {
        Category category = categoryRepository
                .findById(id)
                .map(
                        category1 -> {
                            if (!category1.getName().equals(input.getName())) {
                                if (doesNameExist(input.getName()) || isDataInvalid(input.getName())) {
                                    throw new DataFailedException(
                                            CONFLICT, "Offer name:" + input.getName() +
                                            "was not provided or already exists.");
                                }
                                category1.setName(input.getName());
                            }
                            if (isDataInvalid(input.getPictureUrl())) {
                                throw new DataFailedException(
                                        BAD_REQUEST, "Category picture url was not provided");
                            }
                            category1.setPictureUrl(input.getPictureUrl());
                            return category1;
                        })
                .orElseThrow(itemNotFound("Category with id" + id + " does not exist"));
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    private boolean doesNameExist(String name) {
        Optional<Category> category = categoryRepository.findCategoryByName(name);
        return category.isPresent();
    }

    private boolean isDataInvalid(String data) {
        return data == null || data.isEmpty() || data.trim().isEmpty();
    }
}
