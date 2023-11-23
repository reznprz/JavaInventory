package com.laxmi.inventory.management.inventory.config;

import com.laxmi.inventory.management.inventory.domain.CategoryDomain;
import com.laxmi.inventory.management.inventory.domain.ProductDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    private final CategoryDomain categoryDomain;

    private final ProductDomain productDomain;

    @Autowired
    public DatabaseInitializer(CategoryDomain categoryDomain,
                               ProductDomain productDomain) {
        this.categoryDomain = categoryDomain;
        this.productDomain = productDomain;
    }

    @PostConstruct
    public void init() {

        try {
            insertCategory();
            insertProduct();
        } catch (Exception e) {
            System.out.println("Failed to insert into DB " + e.toString());
        }
    }

    private void insertCategory() {
        // Adding sample categories
        categoryDomain.addCategoryIfNotExist("Coffee", "Various types of coffee");
        categoryDomain.addCategoryIfNotExist("Food", "Assorted food items");
        categoryDomain.addCategoryIfNotExist("Cake", "Different kinds of cakes");
        categoryDomain.addCategoryIfNotExist("Breakfast Items", "Items for breakfast");
    }

    private void insertProduct() {
        productDomain.createProductIfNotExists("Espresso", "Espresso", "image_url_1", 3, 100, "SKU001", 1L);
        productDomain.createProductIfNotExists("Cappuccino", "Cappuccino", "image_url_2", 4, 100, "SKU002", 1L);
        productDomain.createProductIfNotExists("Latte", "Latte", "image_url_3", 4, 100, "SKU003", 1L);
        productDomain.createProductIfNotExists("Americano", "Americano", "image_url_11", 3, 100, "SKU011", 1L);
        productDomain.createProductIfNotExists("Flat White", "Flat White", "image_url_12", 3, 100, "SKU012", 1L);
        productDomain.createProductIfNotExists("Mocha", "Mocha", "image_url_13", 4, 100, "SKU013", 1L);
        productDomain.createProductIfNotExists("Macchiato", "Macchiato", "image_url_14", 4, 100, "SKU014", 1L);
        productDomain.createProductIfNotExists("Iced Coffee", "Iced Coffee", "image_url_15", 4, 100, "SKU015", 1L);
        productDomain.createProductIfNotExists("Ristretto", "Ristretto", "image_url_16", 3, 100, "SKU016", 1L);
        productDomain.createProductIfNotExists("Doppio", "Doppio", "image_url_17", 3, 100, "SKU017", 1L);
        productDomain.createProductIfNotExists("Cortado", "Cortado", "image_url_18", 3, 100, "SKU018", 1L);
        productDomain.createProductIfNotExists("Affogato", "Affogato", "image_url_19", 5, 50, "SKU019", 1L);
        productDomain.createProductIfNotExists("Irish Coffee", "Irish Coffee", "image_url_20", 6, 50, "SKU020", 1L);

        // ...and so on for other coffee products


        productDomain.createProductIfNotExists("Sandwich", "Sandwich", "image_url_4", 5, 50, "SKU004", 2L);
        productDomain.createProductIfNotExists("Burger", "Burger", "image_url_5", 6, 50, "SKU005", 2L);
        productDomain.createProductIfNotExists("Baguette", "Baguette", "image_url_21", 2, 50, "SKU021", 2L);
        productDomain.createProductIfNotExists("Whole Wheat Bread", "Whole Wheat Bread", "image_url_22", 2, 50, "SKU022", 2L);
        productDomain.createProductIfNotExists("Sourdough", "Sourdough", "image_url_24", 3, 50, "SKU024", 2L);
        productDomain.createProductIfNotExists("Focaccia", "Focaccia", "image_url_25", 4, 30, "SKU025", 2L);
        productDomain.createProductIfNotExists("Ciabatta", "Ciabatta", "image_url_26", 4, 30, "SKU026", 2L);
        productDomain.createProductIfNotExists("Brioche", "Brioche", "image_url_27", 4, 30, "SKU027", 2L);
        productDomain.createProductIfNotExists("Pita Bread", "Pita Bread", "image_url_28", 2, 50, "SKU028", 2L);
        productDomain.createProductIfNotExists("Garlic Bread", "Garlic Bread", "image_url_29", 3, 50, "SKU029", 2L);
        productDomain.createProductIfNotExists("Danish Pastry", "Danish Pastry", "image_url_30", 4, 50, "SKU030", 2L);

        // ...and so on for other food items

        productDomain.createProductIfNotExists("Chocolate Cake", "Chocolate Cake", "image_url_6", 4, 30, "SKU006", 3L);
        productDomain.createProductIfNotExists("Cheese Cake", "Cheese Cake", "image_url_7", 4, 30, "SKU007", 3L);
        // ...and so on for other cake products

        productDomain.createProductIfNotExists("Croissant", "Croissant", "image_url_8", 2, 50, "SKU008", 4L);
        productDomain.createProductIfNotExists("Pancakes", "Pancakes", "image_url_9", 5, 50, "SKU009", 4L);
        productDomain.createProductIfNotExists("Omelette", "Omelette", "image_url_10", 5, 50, "SKU010", 4L);
    }
}
