package com.laxmi.inventory.management.inventory.repositories;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    ICategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findByCategoryId(Long categoryId){
        return categoryRepository.findById(categoryId);
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id,Category category){
        return categoryRepository.findById(id).map(categoryObj -> {
            categoryObj.setCategoryName(category.getCategoryName());
            categoryObj.setCategoryDescription(category.getCategoryDescription());

            return categoryRepository.save(categoryObj);
        }).orElseThrow(()-> new ResourceNotFoundException("Category ID "+ id + "not found"));
    }

    public Boolean deleteCategory(Long id){
        return  categoryRepository.findById(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
    }

    @Transactional
    public boolean existsByCategoryName(String categoryName, String categoryDescription) {
        boolean categoryExists = categoryRepository.existsByCategoryName(categoryName);
        return categoryExists;
    }
}
