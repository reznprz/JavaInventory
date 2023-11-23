--INSERT INTO category (categorydescription, categoryname) VALUES
--('Various types of coffee', 'Coffee'),
--('Assorted food items', 'Food'),
--('Different kinds of cakes', 'Cake'),
--('Items for breakfast', 'Breakfast Items');
--
--

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
--('image_url_2', 'Cappuccino', 'Cappuccino', 4, 100, 'SKU002', 1),
--('image_url_3', 'Latte', 'Latte', 4, 100, 'SKU003', 1),
--('image_url_4', 'Sandwich', 'Sandwich', 5, 50, 'SKU004', 2),
--('image_url_5', 'Burger', 'Burger', 6, 50, 'SKU005', 2),
--('image_url_6', 'Chocolate Cake', 'Chocolate Cake', 4, 30, 'SKU006', 3),
--('image_url_7', 'Cheese Cake', 'Cheese Cake', 4, 30, 'SKU007', 3),
--('image_url_8', 'Croissant', 'Croissant', 2, 50, 'SKU008', 4),
--('image_url_9', 'Pancakes', 'Pancakes', 5, 50, 'SKU009', 4),
--('image_url_10', 'Omelette', 'Omelette', 5, 50, 'SKU010', 4);
--
--
--INSERT INTO product (image_url, productdescription, productname, productunitprice, productunitquantitystock, sku, categoryid) VALUES
--('image_url_11', 'Americano', 'Americano', 3, 100, 'SKU011', 1),
--('image_url_12', 'Flat White', 'Flat White', 3, 100, 'SKU012', 1),
--('image_url_13', 'Mocha', 'Mocha', 4, 100, 'SKU013', 1),
--('image_url_14', 'Macchiato', 'Macchiato', 4, 100, 'SKU014', 1),
--('image_url_15', 'Iced Coffee', 'Iced Coffee', 4, 100, 'SKU015', 1),
--('image_url_16', 'Ristretto', 'Ristretto', 3, 100, 'SKU016', 1),
--('image_url_17', 'Doppio', 'Doppio', 3, 100, 'SKU017', 1),
--('image_url_18', 'Cortado', 'Cortado', 3, 100, 'SKU018', 1),
--('image_url_19', 'Affogato', 'Affogato', 5, 50, 'SKU019', 1),
--('image_url_20', 'Irish Coffee', 'Irish Coffee', 6, 50, 'SKU020', 1);
--
--
--INSERT INTO product (image_url, productdescription, productname, productunitprice, productunitquantitystock, sku, categoryid) VALUES
--('image_url_21', 'Baguette', 'Baguette', 2, 50, 'SKU021', 2),
--('image_url_22', 'Whole Wheat Bread', 'Whole Wheat Bread', 2, 50, 'SKU022', 2),
--('image_url_23', 'Rye Bread', 'Rye Bread', 3, 50, 'SKU023', 2),
--('image_url_24', 'Sourdough', 'Sourdough', 3, 50, 'SKU024', 2),
--('image_url_25', 'Focaccia', 'Focaccia', 4, 30, 'SKU025', 2),
--('image_url_26', 'Ciabatta', 'Ciabatta', 4, 30, 'SKU026', 2),
--('image_url_27', 'Brioche', 'Brioche', 4, 30, 'SKU027', 2),
--('image_url_28', 'Pita Bread', 'Pita Bread', 2, 50, 'SKU028', 2),
--('image_url_29', 'Garlic Bread', 'Garlic Bread', 3, 50, 'SKU029', 2),
--('image_url_30', 'Danish Pastry', 'Danish Pastry', 4, 50, 'SKU030', 2);
--
--
