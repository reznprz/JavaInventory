package com.laxmi.inventory.management.inventory.domain;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.Model.DBRow;
import com.laxmi.inventory.management.inventory.repositories.CategoryRepository;
import com.laxmi.inventory.management.inventory.mySqlRepository.SQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryDomain {
    private final CategoryRepository categoryRepository;

    SQLRepository sqlRepository;

    public CategoryDomain(SQLRepository sqlRepository, CategoryRepository categoryRepository){
        this.sqlRepository = sqlRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.getAllCategory();
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

    public List<DBRow> getAllUsers(){
        List<DBRow> results = sqlRepository.getAllUsers();
        return results;
    }

    @Transactional
    public void addCategoryIfNotExist(String categoryName, String categoryDescription) {
        boolean categoryExists = categoryRepository.existsByCategoryName(categoryName, categoryDescription);
        if (!categoryExists) {
            Category category = new Category();
            category.setCategoryDescription(categoryDescription);
            category.setCategoryName(categoryName);
            categoryRepository.createCategory(category);
        }
    }
}
