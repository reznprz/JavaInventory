package com.laxmi.inventory.management.inventory.domain;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryDomain {

    @Autowired
    CategoryRepository categoryRepository;

    public Page<Category> getAllCategory(Pageable pageable){
        return categoryRepository.getAllCategory(pageable);
    }

    public Category createCategory(Category category){
        return categoryRepository.createCategory(category);
    }

    public Category updateCategory(Long id, Category category){
        return categoryRepository.updateCategory(id,category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteCategory(id);
    }
}
