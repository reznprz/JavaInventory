package com.laxmi.inventory.management.inventory.domain;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.Model.DBRow;
import com.laxmi.inventory.management.inventory.repositories.CategoryRepository;
import com.laxmi.inventory.management.inventory.mySqlRepository.SQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDomain {

    @Autowired
    CategoryRepository categoryRepository;

    SQLRepository sqlRepository;

    public CategoryDomain(SQLRepository sqlRepository){
        this.sqlRepository = sqlRepository;
    }

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

    public List<DBRow> getAllUsers(){
        List<DBRow> results = sqlRepository.getAllUsers();
        return results;
    }
}
