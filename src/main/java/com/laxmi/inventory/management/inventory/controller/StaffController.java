package com.laxmi.inventory.management.inventory.controller;

import com.laxmi.inventory.management.inventory.Entity.Category;
import com.laxmi.inventory.management.inventory.Entity.Product;
import com.laxmi.inventory.management.inventory.Entity.Staff;
import com.laxmi.inventory.management.inventory.domain.StaffDomain;
import com.laxmi.inventory.management.inventory.repositories.ICategoryRepository;
import com.laxmi.inventory.management.inventory.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    StaffDomain staffDomain;

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    IProductRepository productRepository;

    @GetMapping("/hi")
    private String hi(){

        Category category = new Category();
        category.setCategoryDescription("Sweets Type");
        category.setCategoryName("Sweets");
        category.setId(1L);

        categoryRepository.save(category);

        Product product = new Product();
        product.setId(1L);
        product.setProductName("Barfi");
        product.setProductUnitQuantityStock(20);
        product.setProductUnitPrice(5);
        product.setProductDescription("Milk product");
        product.setCategory(category);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setProductName("Lado");
        product2.setProductUnitQuantityStock(10);
        product2.setProductUnitPrice(4);
        product2.setProductDescription("Milk product");
        product2.setCategory(category);

        productRepository.save(product);
        productRepository.save(product2);

        return "Hello From Server";
    }

    @PostMapping("/create")
    private ResponseEntity<Staff> saveStaff(@RequestBody Staff staff){
        Staff newStaff = staffDomain.saveStaff(staff);
        return new ResponseEntity<>(newStaff, HttpStatus.OK);
    }

    @GetMapping("/allStaffs")
    private ResponseEntity<List<Staff>> getAllStaffs(){
        try {
            return new ResponseEntity<>(staffDomain.getAllStaffs(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<Staff> getStaffById(@PathVariable("id") long id){
        try{
            Staff staffObj = staffDomain.getStaffById(id);

            if(staffObj != null) {
                return new ResponseEntity<>(staffObj,HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteStaffById(@PathVariable("id") long id){
        try{
            boolean success = staffDomain.deleteStaffById(id);

            if(success){
                return new ResponseEntity<>(true, HttpStatus.OK);
            }

            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/all")
    private ResponseEntity<Boolean> deleteAllStaffs(){
        try{
            boolean success = staffDomain.deleteAllStaffs();

            if(success){
                return new ResponseEntity<>(true, HttpStatus.OK);
            }

            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<Staff> updateStaff(@PathVariable("id") long id, @RequestBody Staff staff){
        Staff staffObj = staffDomain.updateStaff(id, staff);

        if(staffObj != null){
            return new ResponseEntity<>(staffObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
