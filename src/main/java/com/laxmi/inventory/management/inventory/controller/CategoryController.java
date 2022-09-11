package com.laxmi.inventory.management.inventory.controller;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.domain.CategoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    CategoryDomain categoryDomain;

    @GetMapping("/allCategory")
    private Page<Category> getAllCategory(Pageable pageable){
        return categoryDomain.getAllCategory(pageable);
    }

    @PostMapping("/create")
    private Category createCategory(@RequestBody Category category){
        return categoryDomain.createCategory(category);
    }

    @PutMapping("/category/{id}")
    private Category updateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        return categoryDomain.updateCategory(id,category);
    }

    @DeleteMapping("/category/{id}")
    private ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long id){
        try{
            categoryDomain.deleteCategory(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
