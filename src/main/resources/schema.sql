-- Create User table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Insert some rows
INSERT INTO users (username, password) VALUES ('Alice', 'password1');
INSERT INTO users (username, password) VALUES ('Bob', 'password2');

-- Create Customer table
CREATE TABLE IF NOT EXISTS Product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(255) NOT NULL,
    sku VARCHAR(100) UNIQUE NOT NULL,
    imageUrl VARCHAR(255),  -- Assuming URL will be stored as a string
    price DECIMAL(10, 2) NOT NULL,
    inventoryQty INT NOT NULL,
    createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    updatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS Customer (
customerId BIGINT AUTO_INCREMENT PRIMARY KEY,
phoneNumber VARCHAR(20),
firstName VARCHAR(255),
lastName VARCHAR(255),
Address1 VARCHAR(255),
Address2 VARCHAR(255),
Address3 VARCHAR(255),
zipCode INT,
city VARCHAR(255),
email VARCHAR(255),
createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
updatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);





CREATE TABLE IF NOT EXISTS Invoice (
    id INT PRIMARY KEY,
    customerId BIGINT NOT NULL,
    amountBeforeDiscount DECIMAL(10, 2) NOT NULL,
    discount DECIMAL(10, 2) NOT NULL,
    totalAmount DECIMAL(10, 2) NOT NULL,
    createdDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updatedSource VARCHAR(255),
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);

CREATE TABLE IF NOT EXISTS SalesTransaction (
    id INT PRIMARY KEY,
    customerId BIGINT NOT NULL,
    invoiceId INT NOT NULL,
    transactionDate DATE NOT NULL,
    createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    updatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (invoiceId) REFERENCES Invoice(id)
);

CREATE TABLE IF NOT EXISTS InvoiceProducts (
    invoiceId INT,
    productId INT,
    createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    updatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (invoiceId) REFERENCES Invoice(id),
    FOREIGN KEY (productId) REFERENCES Product(id),
    PRIMARY KEY (invoiceId, productId)
);

--INSERT INTO Customer (phoneNumber, firstName, lastName, Address1, Address2, Address3, zipCode, city, email) VALUES
--('1234567890', 'John', 'Doe', '123 Main St', 'Apt 1', 'Floor 2', 12345, 'New York', 'john.doe@example.com'),
--('2345678901', 'Jane', 'Doe', '456 Elm St', 'Apt 2', 'Floor 1', 23456, 'Los Angeles', 'jane.doe@example.com'),
--('3456789012', 'Alice', 'Smith', '789 Oak St', NULL, NULL, 34567, 'Chicago', 'alice.smith@example.com'),
--('4567890123', 'Bob', 'Johnson', '101 Pine St', 'Suite 5', 'Building A', 45678, 'Houston', 'bob.johnson@example.com'),
--('5678901234', 'Carol', 'Williams', '202 Maple Ave', NULL, 'Block 3', 56789, 'Phoenix', 'carol.williams@example.com'),
--('6789012345', 'David', 'Brown', '303 Birch Blvd', 'Unit 10', NULL, 67890, 'Philadelphia', 'david.brown@example.com'),
--('7890123456', 'Eve', 'Davis', '404 Cedar Ln', 'Top Floor', 'Gate 2', 78901, 'San Antonio', 'eve.davis@example.com'),
--('8901234567', 'Frank', 'Miller', '505 Cherry Cir', 'Left Wing', 'Door 3', 89012, 'San Diego', 'frank.miller@example.com'),
--('9012345678', 'Grace', 'Wilson', '606 Dogwood Dr', 'Right Side', 'Sector 4', 90123, 'Dallas', 'grace.wilson@example.com'),
--('1234567890', 'Henry', 'Moore', '707 Elmwood Rd', 'Ground Floor', 'Entrance 5', 12345, 'San Jose', 'henry.moore@example.com'),
--('1254214390', 'Ree', 'Ree', '707 Elmwood Rd', 'Ground Floor', 'Entrance 5', 12345, 'San Jose', 'henry.moore@example.com');
