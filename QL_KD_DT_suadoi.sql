CREATE DATABASE QL_KD_DTDD
USE QL_KD_DTDD

CREATE TABLE KHACHHANG(
MAKH CHAR(10) NOT NULL,
TENKH NVARCHAR(40),
NGAYSINH DATE,
DCHI NVARCHAR(40),
DIENTHOAI CHAR(12),
CONSTRAINT PK_KHACHHANG PRIMARY KEY (MAKH)
)

CREATE TABLE HANG (
MADT CHAR(10) NOT NULL,
TENDT NVARCHAR(50),
SOLUONG INT,
TENSX CHAR(30),
TENCC NVARCHAR(30),
CONSTRAINT PK_HANG PRIMARY KEY (MADT)
)

CREATE TABLE HOADON (
MAHD CHAR(10) NOT NULL,
NGAYBAN DATE,
TENNV CHAR(10),
MAKH CHAR(10),
TIENBAN FLOAT,
GIAMGIA FLOAT,
THANHTIEN FLOAT,
CONSTRAINT PK_HOADON PRIMARY KEY (MAHD)
)

CREATE TABLE CHITIETHD (
MAHD CHAR(10),
MADT CHAR(10),
SOLUONG INT,
GIABAN FLOAT,
THANHTIEN FLOAT,
CONSTRAINT PK_CHITIETHD PRIMARY KEY (MAHD,MADT)
)
CREATE TABLE DONGIA (
MADT CHAR(10),
NGAYAD DATE,
GIA FLOAT,
CONSTRAINT PK_DONGIA PRIMARY KEY (MADT,NGAYAD)
)


ALTER TABLE HOADON
ADD CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH)
ALTER TABLE DONGIA 
ADD CONSTRAINT FK_DONGIA_HANG FOREIGN KEY(MADT) REFERENCES HANG(MADT)
ALTER TABLE CHITIETHD
ADD CONSTRAINT FK_CHITIETHD_HOADON FOREIGN KEY(MAHD) REFERENCES HOADON(MAHD) 
ALTER TABLE CHITIETHD
ADD CONSTRAINT FK_CHITIETHD_HANG FOREIGN KEY(MADT) REFERENCES HANG(MADT)

INSERT INTO KHACHHANG (MAKH,TENKH,NGAYSINH,DCHI,DIENTHOAI)VALUES ('KH01',N'Phan Văn A','1999/01/02',N'30/Cộng Hòa/Q.Tân Phú',0943334162),
                                                                 ('KH02',N'Phan Văn B','1999/02/03',N'31/Lê Trọng Tấn/Q.Tân Phú',0943334183),
																 ('KH03',N'Phan Văn C','1999/03/04',N'30/Lý Thường Kiệt/Q.Tân Bình',0943336453),
																 ('KH04',N'Phan Văn D','1999/04/05',N'30/Tân Sơn Nhì/Q.Tân Phú',0943339999)


INSERT INTO HANG(MADT,TENDT,SOLUONG,TENSX,TENCC) VALUES('SS01','SAMSUNG GALAXY J7',50,'SAMSUNG',N'PHONG VŨ'),
                                                       ('SS02','SAMSUNG GALAXY S10',90,'SAMSUNG',N'PHONG VŨ'),
                                                       ('XM01','XIAOMI REDMI NOTE 7',60,'XIAOMI',N'THẾ GIỚI DI ĐỘNG'),
													   ('XM02','XIAOMI REDMI NOTE 5',80,'XIAOMI',N'THẾ GIỚI DI ĐỘNG'),
													   ('IP01','IPHONE X',70,'APPLE',N'ĐIỆN MÁY XANH'),
													   ('IP02','IPHONE XS MAX',45,'APPLE',N'ĐIỆN MÁY XANH')

INSERT INTO HOADON (MAHD,NGAYBAN,TENNV,MAKH,TIENBAN,GIAMGIA,THANHTIEN) VALUES ('HD01','2018/1/1',N'Lê Thị Anh','KH01',1000000,0.5,NULL),
                                                                              ('HD02','2018/1/1',N'Lê Thị B','KH02',2000000,1.5,NULL),
																			  ('HD03','2018/1/1',N'Lê Thị C','KH03',3500000,0.4,NULL),
																			  ('HD04','2018/1/1',N'Lê Thị D','KH04',4500000,0.3,NULL)

INSERT INTO CHITIETHD (MAHD,MADT,SOLUONG,GIABAN,THANHTIEN) VALUES ('HD01','SS01',1,5000000,NULL),
                                                                  ('HD02','XM01',2,3200000,NULL),
																  ('HD03','IP01',1,5500000,NULL),
																  ('HD04','SS02',1,4500000,NULL)


INSERT INTO DONGIA (MADT,NGAYAD,GIA) VALUES ('SS01','2018/04/03',4000000),
                                            ('SS02','2018/05/03',5000000),
											('XM01','2018/09/05',4500000),
											('XM02','2018/07/04',6000000),
											('IP01','2018/08/03',4300000),
											('IP02','2018/04/06',4200000)




--Cập nhật thành tiền của 'HOADON'		
create proc thanhtien_hoadon
as
begin
	update HOADON
	set thanhtien = tienban * giamgia
end

exec dbo.thanhtien_hoadon


--Cập nhật thành tiền của 'CHITIETHD'					
create proc thanhtien_chitiethd
as
begin
	update CHITIETHD
	set thanhtien = soluong * giaban
end

exec dbo.thanhtien_chitiethd



--Viết trigger thực hiện tự động cập nhật lại 'THANHTIEN' trên bảng 'CHITIETHD'
-- đồng thời cập nhật 'TIENBAN' trên bảng 'HOADON'mỗi khi thêm dữ liệu vào bảng 'CHITIETHD'
create trigger kiemtra1 on chitiethd for update, insert
as
begin
	update chitiethd
	set thanhtien = soluong * giaban
	declare @tienban float
	declare @mahd char(5) = (select mahd from inserted)
	select @tienban = sum(thanhtien) from chitiethd where mahd = @mahd
	update hoadon
	set tienban = @tienban
	where mahd = @mahd
	update hoadon
	set thanhtien = tienban - (tienban * giamgia)
end
go

update chitiethd
set soluong = 2
where mahd = 'hd03' and madt = 'ip01'

select * from chitiethd
select * from hoadon



--Viết trigger thực hiện việc giảm 'SOLUONG' trên bảng 'HANG' mỗi khi bán một loại điện thoại đó ra
--(nhập dữ liệu vào bảng 'CHITIETHD')
create trigger kiemtra4 on chitiethd for insert
as
begin
	declare @madt char(10) = (select madt from inserted)
	declare @soluong int = (select soluong from inserted where madt = @madt)
	update hang
	set soluong = soluong - @soluong
	where madt = @madt
end


INSERT INTO CHITIETHD (MAHD,MADT,SOLUONG,GIABAN,THANHTIEN) VALUES 
	('HD01','SS02',3,5000000,NULL)

select * from chitiethd
select * from hang




--Viết trigger thực hiện lấy ngày hiện tại cho cột 'NGAYBAN' mỗi khi thêm dữ liệu
--vào bảng 'HOADON'
create trigger kiemtra5 on hoadon for insert
as
begin
	declare @mahd char(10) = (select mahd from inserted)
	update hoadon
	set ngayban = getdate()
	where mahd = @mahd
end

INSERT INTO HOADON (MAHD,NGAYBAN,TENNV,MAKH,TIENBAN,GIAMGIA,THANHTIEN) VALUES
	('HD05',NULL,N'Nguyễn H','KH01',1000000,0.5,NULL)
select * from hoadon