CREATE DATABASE SheepShop
GO
USE SheepShop
GO

CREATE TABLE Role (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Name NVARCHAR(50),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Employee (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Code VARCHAR(30) UNIQUE,
							Fullname NVARCHAR(100),
							Username VARCHAR(50) UNIQUE,
							Password VARCHAR(64),
							Image VARCHAR(255),
							Gender BIT,
							Phone VARCHAR(20),
							Email VARCHAR(100),
							Enabled BIT,
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT,
							IdRole INT FOREIGN KEY REFERENCES Role(Id)
);

CREATE TABLE Customer (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Code VARCHAR(30) UNIQUE,
							Fullname NVARCHAR(100),
							Username VARCHAR(50) UNIQUE,
							Password VARCHAR(64),
							Image VARCHAR(255),
							Gender BIT,
							Phone VARCHAR(20),
							Email VARCHAR(100),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Category (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Name NVARCHAR(100),
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Brand (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Name NVARCHAR(100),
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Color (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Name NVARCHAR(100),
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Size (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Name NVARCHAR(100),
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Material (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Name NVARCHAR(100),
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE CollarStyle (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Name NVARCHAR(100),
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Voucher (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Code VARCHAR(30) UNIQUE,
							Name NVARCHAR(100),
							TypeVoucher BIT,
							IsVoucher BIT,
							Discount INT,
							Cash MONEY,
							StartDate DATETIME,
							EndDate DATETIME,
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Product (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Code VARCHAR(30),
							Name NVARCHAR(100),
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT
);

CREATE TABLE Product_Detail (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Price MONEY,
							Discount INT,
							DiscountDate DATETIME,
							Description NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT,
							IdProduct INT FOREIGN KEY REFERENCES Product(Id),
							IdBrand INT FOREIGN KEY REFERENCES Brand(Id),
							IdCollarStyle INT FOREIGN KEY REFERENCES CollarStyle(Id),
							IdMaterial INT FOREIGN KEY REFERENCES Material(Id),
							IdCategory INT FOREIGN KEY REFERENCES Category(Id)
);

CREATE TABLE Product_Image (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Url VARCHAR(255),
							MainImage BIT,
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT,
							IdProduct INT FOREIGN KEY REFERENCES Product(Id)
);

CREATE TABLE Product_Fault (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Note NVARCHAR(255),
							Quantity INT,
							IdColor INT,
							IdSize INT,
							IdCollarStyle INT,			
							IdProductDetail INT FOREIGN KEY REFERENCES Product_Detail(Id)
);

CREATE TABLE ProductDetail_Color_Size (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							IdProductDetail INT FOREIGN KEY REFERENCES Product_Detail(Id),
							IdColor INT FOREIGN KEY REFERENCES Color(Id),
							IdSize INT FOREIGN KEY REFERENCES Size(Id),
							Quantity INT
);

CREATE TABLE Product_Voucher (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							IdVoucher INT FOREIGN KEY REFERENCES Voucher(Id),
							IdProduct INT FOREIGN KEY REFERENCES Product(Id)
);

CREATE TABLE Address (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Fullname NVARCHAR(100),
							Phone VARCHAR(20),
							Address NVARCHAR(255),
							CityName NVARCHAR(100),
							DistrictName NVARCHAR(100),
							WardName NVARCHAR(100),
							IdCity INT,
							IdDistrict INT,
							IdWard INT,
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT,
							IdCustomer INT FOREIGN KEY REFERENCES Customer(Id)
);

CREATE TABLE Coupon (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Code VARCHAR(30),
							Name NVARCHAR(100),
							IsType BIT,
							Discount INT,
							Cash MONEY,
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT,
							IdCustomer INT FOREIGN KEY REFERENCES Customer(Id)
);

CREATE TABLE Bill (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Code VARCHAR(30) UNIQUE,
							PurchaseDate DATETIME,
							EstimatedDate DATETIME,
							PaymentDate DATETIME,
							DeliveryDate DATETIME,
							TotalPrice MONEY,
							ShipPrice MONEY,
							TotalPriceLast MONEY,
							Note NVARCHAR(255),
							PayType INT,
							PayStatus INT,
							TypeStatus INT,
							Status INT,
							CodeGHN VARCHAR(30),
							IdCoupon INT,
							IdAddress INT FOREIGN KEY REFERENCES Address(Id),
							IdEmployee INT FOREIGN KEY REFERENCES Employee(Id),
							IdVoucher INT FOREIGN KEY REFERENCES Voucher(Id),
							IdCustomer INT FOREIGN KEY REFERENCES Customer(Id)
);

CREATE TABLE Bill_Detail (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							UnitPrice MONEY,
							Quantity INT,
							IdColor INT,
							IdSize INT,
							IdOrder INT FOREIGN KEY REFERENCES Bill(Id),
							IdProductDetail INT FOREIGN KEY REFERENCES Product_Detail(Id)
);

CREATE TABLE Bill_History (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							Note NVARCHAR(255),
							CreateDate DATETIME,
							UpdateDate DATETIME,
							CreateBy VARCHAR(30),
							UpdateBy VARCHAR(30),
							Status INT,
							IdOrder INT FOREIGN KEY REFERENCES Bill(Id)
);

CREATE TABLE Cart (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							IdCustomer INT FOREIGN KEY REFERENCES Customer(Id)
);

CREATE TABLE Cart_Detail (
							Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
							UnitPrice MONEY,
							Quantity INT,
							IdColor INT,
							IdSize INT,
							IdCart INT FOREIGN KEY REFERENCES Cart(Id),
							IdProductDetail INT FOREIGN KEY REFERENCES Product_Detail(Id)
);





-- Thêm dữ liệu vào bảng "customer"
INSERT INTO Customer (Code, Fullname, Username, Password, Image, Gender, Phone, Email, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Customer Code', 'Full Name', 'username', '123456', 'Image URL', 1, '0123456789', 'customer@example.com', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "role"
INSERT INTO Role (Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Admin', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "employee"
INSERT INTO Employee (Code, Fullname, Username, Password, Image, Gender, Phone, Email, Enabled, CreateDate, UpdateDate, CreateBy, UpdateBy, status, IdRole)
VALUES ('Employee Code', 'John Doe', 'sa', '123456', 'Image URL', 1, '0123456789', 'employee@example.com', 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1);

-- Thêm dữ liệu vào bảng "category"
INSERT INTO Category (Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Category 1', 'Category 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Category 2', 'Category 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Category 3', 'Category 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "brand"
INSERT INTO Brand (Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Brand 1', 'Brand 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Brand 2', 'Brand 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Brand 3', 'Brand 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "collar_style"
INSERT INTO CollarStyle (Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Collar Style 1', 'Collar Style 1description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Collar Style 2', 'Collar Style 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Collar Style 3', 'Collar Style 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "color"
INSERT INTO Color (Name, description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Color 1', 'Color 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Color 2', 'Color 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Color 3', 'Color 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "size"
INSERT INTO Size (Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Size 1', 'Size 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Size 2', 'Size 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Size 3', 'Size 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "material"
INSERT INTO material (Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Material 1', 'Material 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Material 2', 'Material 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Material 3', 'Material 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "voucher"
INSERT INTO Voucher (Code, Name, TypeVoucher, IsVoucher, Discount, Cash, StartDate, EndDate, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('VOUCHER001', 'Voucher 1', 1, 1, 10, 0, '2024-04-30', '2024-05-31', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('VOUCHER002', 'Voucher 2', 0, 1, 0, 50.00, '2024-04-30', '2024-06-30', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "product"
INSERT INTO Product (Code, Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('P001', 'Product 1', 'Product 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('P002', 'Product 2', 'Product 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('P003', 'Product 3', 'Product 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "product_detail"
INSERT INTO Product_Detail (Price, Discount, DiscountDate, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status, IdProduct, IdBrand, IdCollarStyle, IdMaterial, IdCategory)
VALUES (99.99, 10, '2024-04-30', 'Product 1 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1, 1, 1, 1, 1),
       (149.99, 20, '2024-04-30', 'Product 2 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 2, 2, 2, 2, 2),
       (199.99, 30, '2024-04-30', 'Product 3 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 3, 3, 3, 3, 3);

-- Thêm dữ liệu vào bảng "product_image"
INSERT INTO Product_Image (Url, MainImage, CreateDate, UpdateDate, CreateBy, UpdateBy, Status, IdProduct)
VALUES ('image_url_1', 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1),
       ('image_url_2', 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 2),
       ('image_url_3', 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 3);

-- Thêm dữ liệu vào bảng "product_fault"
INSERT INTO Product_Fault(Note, IdColor, IdSize, IdCollarStyle, Quantity, IdProductDetail)
VALUES ('Fault 1', 1, 1, 1, 5, 1),
       ('Fault 2', 2, 2, 2, 3, 2),
       ('Fault 3', 3, 3, 3, 2, 3);

-- Thêm dữ liệu vào bảng "product_detail_color_size"
INSERT INTO ProductDetail_Color_Size (IdProductDetail, IdColor, IdSize, Quantity)
VALUES (1, 1, 1, 10),
       (2, 2, 2, 5),
       (3, 3, 3, 8);

-- Thêm dữ liệu vào bảng "product_voucher"
INSERT INTO Product_Voucher(IdVoucher, IdProduct)
VALUES (1, 1),
       (2, 2);

-- Thêm dữ liệu vào bảng "address"
INSERT INTO Address(Fullname, Phone, Address, CityName, DistrictName, WardName, IdCity, IdDistrict, IdWard, CreateDate, UpdateDate, CreateBy, UpdateBy , Status, IdCustomer)
VALUES ('John Doe', '123456789', '123 Main Street', 'City', 'District', 'Ward', 1, 1, 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1),
       ('Jane Doe', '987654321', '456 Elm Street', 'City', 'District', 'Ward', 2, 2, 2, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1);

-- Thêm dữ liệu vào bảng "coupon"
INSERT INTO Coupon(Code, Name, IsType, Discount, Cash, CreateDate, UpdateDate, CreateBy, UpdateBy, Status, IdCustomer)
VALUES ('COUPON001', 'Coupon 1', 1, 10, 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 1, 1),
       ('COUPON002', 'Coupon 2', 0, 0, 50.00, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 1, 1);

-- Thêm dữ liệu vào bảng "bill"
INSERT INTO Bill(Code, PurchaseDate, EstimatedDate, PaymentDate, DeliveryDate, TotalPrice, ShipPrice, TotalPriceLast, Note, PayType, PayStatus, TypeStatus, Status, CodeGHN, IdCoupon, IdAddress, IdEmployee, IdVoucher, IdCustomer)
VALUES ('HD01', '2024-04-30', '2024-05-01', '2024-05-02', '2024-05-03', 100.00, 10.00, 110.00, 'Note 1', 1, 1, 1, 10, 'GHN001', 1, 1, 1, 1, 1),
       ('HD02', '2024-04-30', '2024-05-01', '2024-05-02', '2024-05-03', 200.00, 20.00, 220.00, 'Note 2', 2, 1, 1, 10, 'GHN002', 1, 1, 1, 1, 1);

-- Thêm dữ liệu vào bảng "bill_detail"
INSERT INTO Bill_Detail (UnitPrice, Quantity, IdColor, IdSize, IdOrder, IdProductDetail)
VALUES (10.00, 2, 1, 1, 1, 1),
       (20.00, 3, 2, 2, 2, 1);


