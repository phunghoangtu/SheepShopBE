CREATE DATABASE SheepShop
GO
USE SheepShop
GO

CREATE TABLE role (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         name NVARCHAR(50),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
					     status INT,
)
    GO
CREATE TABLE employee (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                         code VARCHAR(30) UNIQUE,
                         fullname NVARCHAR(100),
                         username VARCHAR(50) UNIQUE,
                         password VARCHAR(64),
                         image VARCHAR(255),
                         gender INT,
                         phone VARCHAR(20),
                         email VARCHAR(100),
                         enabled BIT,
                         create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status	INT ,
					     role_id INT FOREIGN KEY REFERENCES role(id) ,
)
    GO
CREATE TABLE customer (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                         code VARCHAR(30) UNIQUE,
                         fullname NVARCHAR(100),
                         username VARCHAR(50) UNIQUE,
                         password VARCHAR(64),
                         image VARCHAR(255),
                         gender INT,
                         phone VARCHAR(20),
                         email VARCHAR(100),
					     create_date DATETIME,
				 	     update_date DATETIME,
				   	     create_by VARCHAR(30),
				  	     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE category (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         name NVARCHAR(100),
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE brand (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         name NVARCHAR(100),
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE color (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         name NVARCHAR(100),
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE size (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         name NVARCHAR(100),
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE material (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         name NVARCHAR(100),
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE collar_style (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         name NVARCHAR(100),
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE voucher (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         code VARCHAR(30) UNIQUE,
                         name NVARCHAR(100),
                         type_voucher BIT,
					     is_voucher BIT,
                         discount INT,
                         cash MONEY,
                         start_date DATETIME,
                         end_date DATETIME,
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
)
    GO
CREATE TABLE product (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         code VARCHAR(30),
                         name NVARCHAR(100),                   
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status	INT ,                                  
)
    GO
CREATE TABLE product_detail (
					     id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         price MONEY,
						 discount int ,
                         discount_date DATETIME,
                         description NVARCHAR(255),
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status	INT ,            
					     product_id INT FOREIGN KEY REFERENCES product(id),	   
					     brand_id INT FOREIGN KEY REFERENCES brand(id),      
					     collar_style_id INT FOREIGN KEY REFERENCES collar_style(id),
						 material_id INT FOREIGN KEY REFERENCES material(id),   
                         category_id INT FOREIGN KEY REFERENCES category(id),   
)
    GO
CREATE TABLE product_image (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         url VARCHAR(255),
					     main_image bit,
					     create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
					     status INT,
					     product_id INT FOREIGN KEY REFERENCES product(id)
)
    GO
CREATE TABLE product_fault (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         note nvarchar(255),
                         color_id INT,
                         size_id INT,
					     collar_style_id INT,
                         quantity INT ,
                         product_detail_id INT FOREIGN KEY REFERENCES product_detail(id),
)
	GO
CREATE TABLE product_detail_color_size (
                         Id int identity(1,1) not null primary key,
                         product_detail_id INT FOREIGN KEY REFERENCES product_detail(id),
                         color_id int foreign key references color(id),
                         size_id int foreign key references size(id),
                         quantity INT,
)
	GO
CREATE TABLE product_voucher(
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                         voucher_id INT FOREIGN KEY REFERENCES voucher(id),
                         product_id INT FOREIGN KEY REFERENCES product(id),
)
	GO
CREATE TABLE address (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY ,
                         fullname NVARCHAR(100),
                         Phone VARCHAR(20),
                         address NVARCHAR(255),
                         city_name NVARCHAR(100),
                         district_name NVARCHAR(100),
                         ward_name NVARCHAR(100),
                         city_id INT,
                         district_id INT,
                         ward_id INT,
                         create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status int,
                         customer_id INT FOREIGN KEY REFERENCES customer(id),
)
	GO
CREATE TABLE coupon (
                         id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                         code VARCHAR(30),
                         name NVARCHAR(100),
                         is_type BIT,
                         discount INT,
                         cash MONEY,
                         create_date DATETIME,
					     update_date DATETIME,
					     create_by VARCHAR(30),
					     update_by VARCHAR(30),
                         status INT,
                         customer_id INT FOREIGN KEY REFERENCES customer(id)
)
	GO
CREATE TABLE bill (
                        id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                        code VARCHAR(30) UNIQUE,
						purchase_date DATETIME,
                        estimated_date DATETIME,
						payment_date DATETIME,
						delyvery_date DATETIME,
						total_price MONEY,
						ship_price MONEY,
						total_price_last MONEY,
						note NVARCHAR(255),
						pay_type INT,
						pay_status INT,
						type_status INT,
						status INT,
						CodeGHN varchar(30),
						coupon_id INT,
						address_id INT FOREIGN KEY REFERENCES address(id),
                        employee_id INT FOREIGN KEY REFERENCES employee(id),
                        voucher_id INT FOREIGN KEY REFERENCES voucher(id),
                        customer_id INT FOREIGN KEY REFERENCES customer(id),
)
    GO
CREATE TABLE bill_detail (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
					   unit_price MONEY,     
					   quantity INT,
                       color_id INT,
                       size_id INT,
                       order_id INT FOREIGN KEY REFERENCES bill(id),
                       product_detail_id INT FOREIGN KEY REFERENCES product_detail(id),                                        
)
    GO
CREATE TABLE bill_history (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       note nvarchar(255),
                       create_date DATETIME,
					   update_date DATETIME,
					   create_by VARCHAR(30),
					   update_by VARCHAR(30),
                       status INT,
                       order_id INT FOREIGN KEY REFERENCES bill(id),
)
	GO
CREATE TABLE cart (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
                       customer_id INT FOREIGN KEY REFERENCES customer(id),
)
    GO
CREATE TABLE cart_detail (
                       id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
					   unit_price MONEY,     
					   quantity INT,
                       color_id INT,
                       size_id INT,
                       cart_id INT FOREIGN KEY REFERENCES cart(id),
                       product_detail_id INT FOREIGN KEY REFERENCES product_detail(id),
)
	GO




-- Thêm dữ liệu vào bảng "customer"
INSERT INTO customer (code, fullname, username, password, image, gender, phone, email, create_date, update_date, create_by, update_by, status)
VALUES ('Customer Code', 'Full Name', 'username', '123456', 'Image URL', 1, '0123456789', 'customer@example.com', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "role"
INSERT INTO role (name, create_date, update_date, create_by, update_by, status)
VALUES ('Admin', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "employee"
INSERT INTO employee (code, fullname, username, password, image, gender, phone, email, enabled, create_date, update_date, create_by, update_by, status, role_id)
VALUES ('Employee Code', 'John Doe', 'sa', '123456', 'Image URL', 1, '0123456789', 'employee@example.com', 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1);

-- Thêm dữ liệu vào bảng "category"
INSERT INTO category (name, description, create_date, update_date, create_by, update_by, status)
VALUES ('Category 1', 'Category 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Category 2', 'Category 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Category 3', 'Category 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "brand"
INSERT INTO brand (name, description, create_date, update_date, create_by, update_by, status)
VALUES ('Brand 1', 'Brand 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Brand 2', 'Brand 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Brand 3', 'Brand 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "collar_style"
INSERT INTO collar_style (name, description, create_date, update_date, create_by, update_by, status)
VALUES ('Collar Style 1', 'Collar Style 1description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Collar Style 2', 'Collar Style 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Collar Style 3', 'Collar Style 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "color"
INSERT INTO color (name, description, create_date, update_date, create_by, update_by, status)
VALUES ('Color 1', 'Color 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Color 2', 'Color 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Color 3', 'Color 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "size"
INSERT INTO size (name, description, create_date, update_date, create_by, update_by, status)
VALUES ('Size 1', 'Size 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Size 2', 'Size 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Size 3', 'Size 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "material"
INSERT INTO material (name, description, create_date, update_date, create_by, update_by, status)
VALUES ('Material 1', 'Material 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Material 2', 'Material 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Material 3', 'Material 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "voucher"
INSERT INTO voucher (code, name, type_voucher, is_voucher, discount, cash, start_date, end_date, create_date, update_date, create_by, update_by, status)
VALUES ('VOUCHER001', 'Voucher 1', 1, 1, 10, 0, '2024-04-30', '2024-05-31', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('VOUCHER002', 'Voucher 2', 0, 1, 0, 50.00, '2024-04-30', '2024-06-30', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "product"
INSERT INTO product (code, name, description, create_date, update_date, create_by, update_by, status)
VALUES ('P001', 'Product 1', 'Product 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('P002', 'Product 2', 'Product 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('P003', 'Product 3', 'Product 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "product_detail"
INSERT INTO product_detail (price, discount, discount_date, description, create_date, update_date, create_by, update_by, status, product_id, brand_id, collar_style_id, material_id, category_id)
VALUES (99.99, 10, '2024-04-30', 'Product 1 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1, 1, 1, 1, 1),
       (149.99, 20, '2024-04-30', 'Product 2 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 2, 2, 2, 2, 2),
       (199.99, 30, '2024-04-30', 'Product 3 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 3, 3, 3, 3, 3);

-- Thêm dữ liệu vào bảng "product_image"
INSERT INTO product_image (url, main_image, create_date, update_date, create_by, update_by, status, product_id)
VALUES ('image_url_1', 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1),
       ('image_url_2', 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 2),
       ('image_url_3', 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 3);

-- Thêm dữ liệu vào bảng "product_fault"
INSERT INTO product_fault (note, color_id, size_id, collar_style_id, quantity, product_detail_id)
VALUES ('Fault 1', 1, 1, 1, 5, 1),
       ('Fault 2', 2, 2, 2, 3, 2),
       ('Fault 3', 3, 3, 3, 2, 3);

-- Thêm dữ liệu vào bảng "product_detail_color_size"
INSERT INTO product_detail_color_size (product_detail_id, color_id, size_id, quantity)
VALUES (1, 1, 1, 10),
       (2, 2, 2, 5),
       (3, 3, 3, 8);

-- Thêm dữ liệu vào bảng "product_voucher"
INSERT INTO product_voucher (voucher_id, product_id)
VALUES (1, 1),
       (2, 2);

-- Thêm dữ liệu vào bảng "address"
INSERT INTO address (fullname, Phone, address, city_name, district_name, ward_name, city_id, district_id, ward_id, create_date, update_date, create_by, update_by, status, customer_id)
VALUES ('John Doe', '123456789', '123 Main Street', 'City', 'District', 'Ward', 1, 1, 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1),
       ('Jane Doe', '987654321', '456 Elm Street', 'City', 'District', 'Ward', 2, 2, 2, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1);

-- Thêm dữ liệu vào bảng "coupon"
INSERT INTO coupon (code, name, is_type, discount, cash, create_date, update_date, create_by, update_by, status, customer_id)
VALUES ('COUPON001', 'Coupon 1', 1, 10, 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 1, 1),
       ('COUPON002', 'Coupon 2', 0, 0, 50.00, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 1, 1);

-- Thêm dữ liệu vào bảng "bill"
INSERT INTO bill (code, purchase_date, estimated_date, payment_date, delyvery_date, total_price, ship_price, total_price_last, note, pay_type, pay_status, type_status, status, CodeGHN, coupon_id, address_id, employee_id, voucher_id, customer_id)
VALUES ('BILL001', '2024-04-30', '2024-05-01', '2024-05-02', '2024-05-03', 100.00, 10.00, 110.00, 'Note 1', 1, 1, 1, 10, 'GHN001', 1, 1, 1, 1, 1),
       ('BILL002', '2024-04-30', '2024-05-01', '2024-05-02', '2024-05-03', 200.00, 20.00, 220.00, 'Note 2', 2, 1, 1, 10, 'GHN002', 1, 1, 1, 1, 1);

-- Thêm dữ liệu vào bảng "bill_detail"
INSERT INTO bill_detail (unit_price, quantity, color_id, size_id, order_id, product_detail_id)
VALUES (10.00, 2, 1, 1, 1, 1),
       (20.00, 3, 2, 2, 2, 1);


