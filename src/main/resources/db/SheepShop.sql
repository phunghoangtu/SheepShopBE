Create database SheepShop
go
use SheepShop
go

create table Role(
						 Id int identity(1,1) not null primary key,
						 Name nvarchar(50),
						 CreateDate Datetime,
						 UpdateDate Datetime,
						 CreateBy varchar(30),
						 UpdateBy varchar(30),
						 Status int

)
Create table Employee(
                         Id int identity(1,1) not null primary key,
                         Code varchar(30),
                         Fullname nvarchar(100),
                         Username varchar(30),
                         Password varchar(30),
                         Image varchar(255),
                         Gender bit,
                         Phone varchar(15),
                         Email varchar(50),
                         CreateDate Datetime,
                         UpdateDate Datetime,
                         CreateBy varchar(30),
                         UpdateBy varchar(30),
                         Status int,
                         IdRole int foreign key references Role(Id)
)
Create table Customer(
                         Id int identity(1,1) not null primary key,
                         Code varchar(30),
                         Fullname nvarchar(100),
                         Username varchar(30),
                         Password varchar(30),
                         Image varchar(255),
                         Gender bit,
                         Phone varchar(15),
                         Email varchar(50),
                         CreateDate Datetime,
                         UpdateDate Datetime,
                         CreateBy varchar(30),
                         UpdateBy varchar(30),
                         Status int
)
Create table Coupon(
                       Id int identity(1,1) not null primary key,
                       Code varchar(30),
                       Name nvarchar(100),
                       IsType bit,
                       Discount int,
                       Cash money,
                       CreateDate Datetime,
                       UpdateDate Datetime,
                       CreateBy varchar(30),
                       UpdateBy varchar(30),
                       Status int,
                       IdCustomer int foreign key references Customer(Id)

)
Create table Background(
                           Id int identity(1,1) not null primary key,
                           Type varchar(30),
                           Url varchar(255),
                           Content nvarchar(255),
                           CreateDate Datetime,
                           UpdateDate Datetime,
                           CreateBy varchar(30),
                           UpdateBy varchar(30),
                           Status int

)
Create table Brand(
                      Id int identity(1,1) not null primary key,
                      Name nvarchar(100),
                      Description nvarchar(255),
                      CreateDate Datetime,
                      UpdateDate Datetime,
                      CreateBy varchar(30),
                      UpdateBy varchar(30),
                      Status int

)
Create table Category(
                         Id int identity(1,1) not null primary key,
                         Name nvarchar(100),
                         Description nvarchar(255),
                         CreateDate Datetime,
                         UpdateDate Datetime,
                         CreateBy varchar(30),
                         UpdateBy varchar(30),
                         Status int
)

Create table Design(
                       Id int identity(1,1) not null primary key,
                       Name nvarchar(100),
                       Description nvarchar(255),
                       CreateDate Datetime,
                       UpdateDate Datetime,
                       CreateBy varchar(30),
                       UpdateBy varchar(30),
                       Status int
)
Create table Size(
							 Id int identity(1,1) not null primary key,
							 Name nvarchar(100),
							 Description nvarchar(255),
							 CreateDate Datetime,
							 UpdateDate Datetime,
							 CreateBy varchar(30),
							 UpdateBy varchar(30),
							 Status int
)
Create table Color(
							  Id int identity(1,1) not null primary key,
							  Name nvarchar(100),
							  Description nvarchar(255),
							  CreateDate Datetime,
							  UpdateDate Datetime,
							  CreateBy varchar(30),
							  UpdateBy varchar(30),
							  Status int
)
Create table Product(
											Id int identity(1,1) not null primary key,
											Code varchar(30),
											Name nvarchar(100),
											Description nvarchar(255),
											CreateDate Datetime,
											UpdateDate Datetime,
											CreateBy varchar(30),
											UpdateBy varchar(30),
											Status int

)
Create table ProductImage(
										 Id int identity(1,1) not null primary key,
										 Url nvarchar(255),
										 MainImage bit,
										 CreateDate Datetime,
										 UpdateDate Datetime,
										 CreateBy varchar(30),
										 UpdateBy varchar(30),
										 Status int,
										 IdProduct int foreign key references Product(Id)
)
Create table ProductDetail(
										  Id int identity(1,1) not null primary key,
										  Weight float,
										  Price money,
										  Discount int ,
										  DiscountDate Datetime,
										  Description nvarchar(255),
										  CreateDate Datetime,
										  UpdateDate Datetime,
										  CreateBy varchar(30),
										  UpdateBy varchar(30),
										  Status int,
										  IdProduct int foreign key references Product(Id),
										  IdBrand int foreign key references Brand(Id),                           
										  IdCategory int foreign key references Category(Id),                          
										  IdDesign int foreign key references Design(Id)
)
Create table ProductFault(
										 Id int identity(1,1) not null primary key,
										 Note nvarchar(255),
										 IdColor int ,
										 IdSize int ,
										 Quantity int ,
										 IdProductDetail int foreign key references ProductDetail(Id)

)
Create table Material(
										 Id int identity(1,1) not null primary key,
										 Name nvarchar(100),
										 Description nvarchar(255),
										 CreateDate Datetime,
										 UpdateDate Datetime,
										 CreateBy varchar(30),
										 UpdateBy varchar(30),
										 Status int
)
Create table ProductDetail_Material(
										   Id int identity(1,1) not null primary key,
										   IdProductDetail int foreign key references ProductDetail(Id),
										   IdMaterial int foreign key references Material(Id)
)

Create table ProductDetail_Color_Size(
                                         Id int identity(1,1) not null primary key,
                                         IdProductDetail int foreign key references ProductDetail(Id),
                                         IdColor int foreign key references Color(Id),
                                         IdSize int foreign key references Size(Id),
                                         Quantity int
)

Create table Voucher(
                        Id int identity(1,1) not null primary key,
                        Code varchar(30),
                        Name nvarchar(100),
                        TypeVoucher bit,
                        IsVoucher bit,
                        Discount int ,
                        Cash money,
                        StartDate Datetime,
                        EndDate Datetime,
                        CreateDate Datetime,
                        UpdateDate Datetime,
                        CreateBy varchar(30),
                        UpdateBy varchar(30),
                        Minimum int,
                        Status int

)
Create table Product_Voucher(
                                Id int identity(1,1) not null primary key,
                                IdVoucher int foreign key references Voucher(Id),
                                IdProduct int foreign key references Product(Id),
)
Create table ProductDetailHistory(
                                     Id int identity(1,1) primary key not null,
                                     ImageMain varchar(max),
										ImageList varchar(max),
										UpdateDate datetime,
										UpdateBy varchar(30),
										Name nvarchar(100),
										Price money,
										Weight float,
										Description nvarchar(255),
										IdCategory int ,
										IdBrand int,
										IdToe int,
										IdSole int,
										IdShoelace int,
										IdHeelcushion int ,
										IdDesign int ,
										IdMaterial varchar(max),
										IdVoucher varchar(max),
										IdColor_Size_Quantity varchar(max),
										Discount int,
										DiscountDate datetime,
										SupplierName nvarchar(100),
										SupplierPhone varchar(15),
										SupplierAddress nvarchar(255),
										SupplierAgree nvarchar(255),
										IdProductDetail int foreign key references ProductDetail(Id)
)

Create table Address(
                        Id int identity(1,1) not null primary key,
                        Fullname nvarchar(100),
                        Phone varchar(15),
                        Address nvarchar(255),
                        CityName nvarchar(100),
                        DistrictName nvarchar(100),
                        WardName nvarchar(100),
                        CityId int,
                        DistrictId int ,
                        WardId int,
                        CreateDate Datetime,
                        UpdateDate Datetime,
                        CreateBy varchar(30),
                        UpdateBy varchar(30),
                        Status int,
                        IdCustomer int foreign key references Customer(Id),
)
Create table Bill(
							 Id int identity(1,1) not null primary key,
							 Code varchar(30),
							 PurchaseDate Datetime,
							 EstimatedDate Datetime,
							 PaymentDate Datetime,
							 DelyveryDate Datetime,
							 TotalPrice money,
							 ShipPrice money,
							 TotalPriceLast money,
							 Note nvarchar(255),
							 PayType int ,
							 PayStatus int,
							 TypeStatus int,
							 Status int,
							 CodeGHN varchar(30),
							 IdCoupon int,
							 IdAddress int foreign key references Address(Id),
							 IdCustomer int foreign key references Customer(Id),
							 IdVoucher int foreign key references Voucher(Id),
							 IdEmployee int foreign key references Employee(Id)

)
Create table BillDetail(
                           Id int identity(1,1) not null primary key,
                           UnitPrice money,
                           Quantity int,
                           IdColor int,
                           IdSize int,
                           IdOrder int foreign key references Bill(Id),
                           IdProductDetail int foreign key references ProductDetail(Id)
)
Create table BillHistory(
                            Id int identity(1,1) not null primary key,
                            Note nvarchar(255),
                            CreateDate Datetime,
                            UpdateDate Datetime,
                            CreateBy varchar(30),
                            UpdateBy varchar(30),
                            Status int,
                            IdOrder int foreign key references Bill(Id)

)
Create table Rating(
                       Id int identity(1,1) not null primary key,
                       Score int,
                       Note nvarchar(255),
                       CreateDate Datetime,
                       UpdateDate Datetime,
                       CreateBy varchar(30),
                       UpdateBy varchar(30),
                       Status int,
                       IdProductDetail int foreign key references ProductDetail(Id),
                       IdCustomer int foreign key references Customer(Id)

)
Create table RatingImage(
                            Id int identity(1,1) not null primary key,
                            Url varchar(255),
                            IdRating int foreign key references Rating(Id)

)
Create table Cart(
                     Id int identity(1,1) not null primary key,
                     IdCustomer int foreign key references Customer(Id)

)
Create table CartDetail(
                           Id int identity(1,1) not null primary key,
                           UnitPrice money,
                           Quantity int,
                           IdColor int,
                           IdSize int,
                           IdCart int foreign key references Cart(Id),
                           IdProductDetail int foreign key references ProductDetail(Id)

)

create table OperationHistory(
                                 Id int identity(1,1) not null primary key,
                                 CreateDate datetime,
                                 CreateBy nvarchar(100),
                                 IdProductDetail int,
                                 Status int

)





-- Thêm dữ liệu vào bảng "customer"
INSERT INTO Customer (Code, Fullname, Username, Password, Image, Gender, Phone, Email, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Customer Code', 'Full Name', 'username', '123456', 'Image URL', 1, '0123456789', 'customer@example.com', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "role"
INSERT INTO Role (Name, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Admin', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "employee"
INSERT INTO Employee (Code, Fullname, Username, Password, Image, Gender, Phone, Email, CreateDate, UpdateDate, CreateBy, UpdateBy, status, IdRole)
VALUES ('Employee Code', 'John Doe', 'sa', '123', 'Image URL', 1, '0123456789', 'employee@example.com', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1);

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
INSERT INTO Design (Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('Design 1', 'Design 1description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Design 2', 'Design 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('Design 3', 'Design 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

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
       ('VOUCHER002', 'Voucher 2', 0, 1, 0, 50, '2024-04-30', '2024-06-30', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "product"
INSERT INTO Product (Code, Name, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status)
VALUES ('P001', 'Product 1', 'Product 1 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('P002', 'Product 2', 'Product 2 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0),
       ('P003', 'Product 3', 'Product 3 description', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0);

-- Thêm dữ liệu vào bảng "product_detail"
INSERT INTO ProductDetail (Price, Discount, DiscountDate, Description, CreateDate, UpdateDate, CreateBy, UpdateBy, Status, IdProduct, IdBrand, IdDesign, IdCategory)
VALUES (100000, 10, '2024-04-30', 'Product 1 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1, 1, 1,  1),
       (150000, 20, '2024-04-30', 'Product 2 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 2, 2, 2, 2),
       (2000000, 30, '2024-04-30', 'Product 3 detail', '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 3, 3, 3,  3);

-- Thêm dữ liệu vào bảng "product_image"
INSERT INTO ProductImage (Url, MainImage, CreateDate, UpdateDate, CreateBy, UpdateBy, Status, IdProduct)
VALUES ('image_url_1', 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1),
       ('image_url_2', 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 2),
       ('image_url_3', 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 3);

-- Thêm dữ liệu vào bảng "product_fault"
INSERT INTO ProductFault(Note, IdColor, IdSize, Quantity, IdProductDetail)
VALUES ('Fault 1', 1, 1, 5, 1),
       ('Fault 2', 2, 2, 3, 2),
       ('Fault 3', 3, 3, 2, 3);

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
INSERT INTO Address(Fullname, Phone, Address, CityName, DistrictName, WardName, CityId, DistrictId, WardId, CreateDate, UpdateDate, CreateBy, UpdateBy , Status, IdCustomer)
VALUES ('John Doe', '123456789', '123 Main Street', 'City', 'District', 'Ward', 1, 1, 1, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1),
       ('Jane Doe', '987654321', '456 Elm Street', 'City', 'District', 'Ward', 2, 2, 2, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 0, 1);

-- Thêm dữ liệu vào bảng "coupon"
INSERT INTO Coupon(Code, Name, IsType, Discount, Cash, CreateDate, UpdateDate, CreateBy, UpdateBy, Status, IdCustomer)
VALUES ('COUPON001', 'Coupon 1', 1, 10, 0, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 1, 1),
       ('COUPON002', 'Coupon 2', 0, 0, 50.00, '2024-04-30', '2024-04-30', 'Admin', 'Admin', 1, 1);

-- Thêm dữ liệu vào bảng "bill"
INSERT INTO Bill(Code, PurchaseDate, EstimatedDate, PaymentDate, DelyveryDate, TotalPrice, ShipPrice, TotalPriceLast, Note, PayType, PayStatus, TypeStatus, Status, CodeGHN, IdCoupon, IdAddress, IdEmployee, IdVoucher, IdCustomer)
VALUES ('HD01', '2024-04-30', '2024-05-01', '2024-05-02', '2024-05-03', 100.00, 10.00, 110.00, 'Note 1', 1, 1, 1, 10, 'GHN001', 1, 1, 1, 1, 1),
       ('HD02', '2024-04-30', '2024-05-01', '2024-05-02', '2024-05-03', 200.00, 20.00, 220.00, 'Note 2', 2, 1, 1, 10, 'GHN002', 1, 1, 1, 1, 1);

-- Thêm dữ liệu vào bảng "bill_detail"
INSERT INTO BillDetail (UnitPrice, Quantity, IdColor, IdSize, IdOrder, IdProductDetail)
VALUES (10.00, 2, 1, 1, 1, 1),
       (20.00, 3, 1, 1, 1, 1);


