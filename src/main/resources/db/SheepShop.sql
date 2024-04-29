CREATE DATABASE SheepShop
GO
USE SheepShop
GO

CREATE TABLE category (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                       name NVARCHAR(50) ,
                       description NVARCHAR(max) ,
                       status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE image (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                       code VARCHAR(255) ,
)
    GO

CREATE TABLE brand (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       name NVARCHAR(50) ,
                       description NVARCHAR(max) ,
                       status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE collar_style (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       name NVARCHAR(50),
                       description NVARCHAR(max) ,
                       status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE color (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       name NVARCHAR(50),
                       description NVARCHAR(max) ,
                       status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE size (
                      id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                      name NVARCHAR(50),
                      description NVARCHAR(max) ,
                      status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE material (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       name NVARCHAR(50),
                       description NVARCHAR(max) ,
                       status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE product (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                       code VARCHAR(30) UNIQUE ,
                       name NVARCHAR(50) ,
                       quantity INT ,
                       price DECIMAL ,
                       description NVARCHAR(max) ,
                       status	INT DEFAULT 0 ,
                       brand_id INT REFERENCES brand(id) ,
                       collar_style_id INT REFERENCES collar_style(id) ,
                       color_id INT REFERENCES color(id) ,
                       size_id INT REFERENCES size(id) ,
                       material_id INT REFERENCES material(id) ,
                       category_id INT REFERENCES category(id) ,
                       image_id INT REFERENCES image(id) ,
)
    GO
CREATE TABLE customer (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                       code VARCHAR(30) UNIQUE ,
                       fullname NVARCHAR(100) ,
                       username VARCHAR(50) ,
                       password VARCHAR(70) ,
                       image VARCHAR(max) ,
                       gender BIGINT ,
                       phone VARCHAR(20) ,
                       email VARCHAR(100) ,
                       status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE role (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                       name NVARCHAR(50) ,
					   status	INT DEFAULT 0 ,
)
    GO
CREATE TABLE employee (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                       code VARCHAR(30) UNIQUE ,
                       fullname NVARCHAR(100) ,
                       username VARCHAR(50) UNIQUE ,
                       password VARCHAR(256) ,
                       image VARCHAR(max) ,
                       gender BIGINT ,
                       phone VARCHAR(20) ,
                       email VARCHAR(100) ,
                       enabled BIT,
                       createBy varchar(30) ,
                       updateBy varchar(30) ,
                       status	INT DEFAULT 0,
					   role_id INT REFERENCES role(id) ,
)
    GO

CREATE TABLE voucher (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                       code VARCHAR(30) UNIQUE ,
                       name NVARCHAR(100) ,
                       type_voucher BIT ,
                       discount INT ,
                       Cash DECIMAL ,
                       start_date DATE ,
                       end_date DATE ,
                       status INT DEFAULT 0 ,
)
    GO

CREATE TABLE bill (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       code VARCHAR(30) UNIQUE,
                       payment_date DATETIME2 ,
                       total_price DECIMAL ,
                       total_price_last DECIMAL ,
                       pay_type  INT ,
                       pay_status INT default 0,
                       code_ghn VARCHAR(30) ,
                       employee_id INT REFERENCES employee(id),
                       voucher_id INT REFERENCES voucher(id),
                       customer_id INT REFERENCES customer(id),
)
    GO
CREATE TABLE bill_detail (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       quantity INT ,
                       price DECIMAL ,
                       bill_id INT REFERENCES bill(id),
                       product_id INT REFERENCES product(id),
)
    GO
CREATE TABLE cart (
                       id INT IDENTITY(1,1) PRIMARY KEY,
                       customer_id INT REFERENCES customer(id),
)
    GO
CREATE TABLE cart_detail (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       quantity INT ,
                       price DECIMAL ,
                       cart_id INT REFERENCES bill(id),
                       product_id INT REFERENCES product(id),
)
    GO

-- Thêm dữ liệu vào bảng "category"
INSERT INTO category (name, description, status)
VALUES
    ('Category 1', 'Description 1', 0),
    ('Category 2', 'Description 2', 0),
    ('Category 3', 'Description 3', 0),
    ('Category 4', 'Description 4', 0),
    ('Category 5', 'Description 5', 0);

-- Thêm dữ liệu vào bảng "image"
INSERT INTO image (code)
VALUES
    ('images1.jpg'),
    ('images2.jpg'),
    ('images3.jpg'),
    ('images4.jpg'),
    ('images5.jpg');

-- Thêm dữ liệu vào bảng "brand"
INSERT INTO brand (name, description, status)
VALUES
    ('Brand 1', 'Description 1', 0),
    ('Brand 2', 'Description 2', 0),
    ('Brand 3', 'Description 3', 0),
    ('Brand 4', 'Description 4', 0),
    ('Brand 5', 'Description 5', 0);

-- Thêm dữ liệu vào bảng "collar_style"
INSERT INTO collar_style (name, description, status)
VALUES
    ('Collar Style 1', 'Description 1', 0),
    ('Collar Style 2', 'Description 2', 0),
    ('Collar Style 3', 'Description 3', 0),
    ('Collar Style 4', 'Description 4', 0),
    ('Collar Style 5', 'Description 5', 0);

-- Thêm dữ liệu vào bảng "color"
INSERT INTO color (name, description, status)
VALUES
    ('Color 1', 'Description 1', 0),
    ('Color 2', 'Description 2', 0),
    ('Color 3', 'Description 3', 0),
    ('Color 4', 'Description 4', 0),
    ('Color 5', 'Description 5', 0);

-- Thêm dữ liệu vào bảng "size"
INSERT INTO size (name, description, status)
VALUES
    ('Size 1', 'Description 1', 0),
    ('Size 2', 'Description 2', 0),
    ('Size 3', 'Description 3', 0),
    ('Size 4', 'Description 4', 0),
    ('Size 5', 'Description 5', 0);

-- Thêm dữ liệu vào bảng "material"
INSERT INTO material (name, description, status)
VALUES
    ('Material 1', 'Description 1', 0),
    ('Material 2', 'Description 2', 0),
    ('Material 3', 'Description 3', 0),
    ('Material 4', 'Description 4', 0),
    ('Material 5', 'Description 5', 0);

-- Thêm dữ liệu vào bảng "product_detail"
INSERT INTO product
(brand_id, collar_style_id, color_id, size_id, material_id, category_id, image_id, code, name, quantity, price, description, status)
VALUES
    (1, 1, 1, 1, 1, 1, 1, 'CODE1', 'Product 1', 10, 19.99, 'Description 1', 0),
    (1, 1, 1, 1, 1, 1, 2, 'CODE2', 'Product 2', 50, 29.99, 'Description 2', 0),
    (1, 1, 1, 1, 1, 1, 3, 'CODE3', 'Product 3', 10, 39.99, 'Description 3', 0),
    (1, 1, 1, 1, 1, 1, 4, 'CODE4', 'Product 4', 10, 49.99, 'Description 4', 0),
    (1, 1, 1, 1, 1, 1, 5, 'CODE5', 'Product 5', 10, 59.99, 'Description 5', 0),
    (2, 2, 2, 2, 2, 2, 1, 'CODE6', 'Product 6', 10, 19.99, 'Description 6', 0),
    (2, 2, 2, 2, 2, 2, 2, 'CODE7', 'Product 7', 50, 29.99, 'Description 7', 0),
    (2, 2, 2, 2, 2, 2, 3, 'CODE8', 'Product 8', 10, 39.99, 'Description 8', 0),
    (2, 2, 2, 2, 2, 2, 4, 'CODE9', 'Product 9', 10, 49.99, 'Description 9', 0),
    (2, 2, 2, 2, 2, 2, 5, 'CODE10', 'Product 10', 1, 59.99, 'Description 10', 0),
    (3, 3, 3, 3, 3, 3, 1, 'CODE11', 'Product 11', 1, 19.99, 'Description 11', 0),
    (3, 3, 3, 3, 3, 3, 2, 'CODE12', 'Product 12', 5, 29.99, 'Description 12', 0),
    (3, 3, 3, 3, 3, 3, 3, 'CODE13', 'Product 13', 1, 39.99, 'Description 13', 0),
    (3, 3, 3, 3, 3, 3, 4, 'CODE14', 'Product 14', 1, 49.99, 'Description 14', 0),
    (3, 3, 3, 3, 3, 3, 5, 'CODE15', 'Product 15', 1, 59.99, 'Description 15', 0),
    (4, 4, 4, 4, 4, 4, 1, 'CODE16', 'Product 16', 1, 19.99, 'Description 16', 0),
    (4, 4, 4, 4, 4, 4, 2, 'CODE17', 'Product 17', 5, 29.99, 'Description 17', 0),
    (4, 4, 4, 4, 4, 4, 3, 'CODE18', 'Product 18', 1, 39.99, 'Description 18', 0),
    (4, 4, 4, 4, 4, 4, 4, 'CODE19', 'Product 19', 1, 49.99, 'Description 19', 0),
    (4, 4, 4, 4, 4, 4, 5, 'CODE20', 'Product 20', 1, 59.99, 'Description 20', 0),
    (5, 5, 5, 5, 5, 5, 1, 'CODE21', 'Product 21', 1, 19.99, 'Description 21', 0),
    (5, 5, 5, 5, 5, 5, 2, 'CODE22', 'Product 22', 5, 29.99, 'Description 22', 0),
    (5, 5, 5, 5, 5, 5, 3, 'CODE23', 'Product 23', 1, 39.99, 'Description 23', 0),
    (5, 5, 5, 5, 5, 5, 4, 'CODE24', 'Product 24', 1, 49.99, 'Description 24', 0),
    (5, 5, 5, 5, 5, 5, 5, 'CODE25', 'Product 25', 1, 59.99, 'Description 25', 0);

-- Thêm dữ liệu vào bảng "customer"
INSERT INTO customer (code, fullname, image, gender, phone, email, status)
VALUES
    ('C001', 'John Doe', 'image1.jpg', 1, '123456789', 'johndoe@example.com', 0),
    ('C002', 'Jane Smith', 'image2.jpg', 2, '987654321', 'janesmith@example.com', 0),
    ('C003', 'Michael Johnson', 'image3.jpg', 1, '456789123', 'michaeljohnson@example.com', 0),
    ('C004', 'Emily Davis', 'image4.jpg', 2, '321654987', 'emilydavis@example.com', 0),
    ('C005', 'David Wilson', 'image5.jpg', 1, '789123456', 'davidwilson@example.com', 0);

-- Thêm dữ liệu vào bảng "role"
INSERT INTO role (name)
VALUES
    ('Admin');

-- Thêm dữ liệu vào bảng "users"
INSERT INTO employee(code, fullname, username, image, gender, phone, email, enabled, role_id , createBy, updateBy)
VALUES
    ('U001', 'John Doe', 'sa', 'image1.jpg', 0, '0123456789', 'johndoe@example.com', 1, 1 , 'Admin', 'Admin'),
	('U002', 'Test', 'Test', 'image1.jpg', 0, '0123456789', 'johndoe@example.com', 1, 1 , 'Admin', 'Admin'),
	('U003', 'Hoàng Tú', 'Admin', 'image1.jpg', 0, '0123456789', 'johndoe@example.com', 1, 1 , 'Admin', 'Admin');

-- Thêm dữ liệu vào bảng "voucher"
INSERT INTO voucher (code, name, type_voucher, discount, Cash, start_date, end_date, status)
VALUES
    ('V001', 'First Time Discount', 1, 10, 50.00, '2024-01-01', '2024-12-31', 0),
    ('V002', 'Holiday Special', 0, 20, 100.00, '2024-12-01', '2025-01-15', 0),
    ('V003', 'New Year Sale', 1, 15, 75.00, '2024-12-25', '2025-01-05', 0),
    ('V004', 'Birthday Gift', 0, 25, 125.00, '2024-03-01', '2024-03-31', 0),
    ('V005', 'Summer Promotion', 1, 30, 150.00, '2024-06-01', '2024-08-31', 0);

-- Thêm dữ liệu vào bảng "bill"
INSERT INTO bill (code, payment_date, total_price, total_price_last, pay_type, pay_status, code_ghn, employee_id, voucher_id, customer_id)
VALUES
    ('B001', GETDATE() , 500.00, 500.00 , 1, 0 , 'GHNCODE001' , 1, 1, 1),
	('B002', GETDATE() , 500.00, 500.00 , 1, 0 , 'GHNCODE001' , 1, 1, 1),
	('B003', GETDATE() , 500.00, 500.00 , 1, 0 , 'GHNCODE001' , 1, 1, 1),
	('B004', GETDATE() , 500.00, 500.00 , 1, 0 , 'GHNCODE001' , 1, 1, 1),
	('B005', GETDATE() , 500.00, 500.00 , 1, 0 , 'GHNCODE001' , 1, 1, 1);

-- Thêm dữ liệu vào bảng "bill_detail"
INSERT INTO bill_detail (bill_id, product_id, quantity, price)
VALUES
    (Null, 1, 2, 50.00);
