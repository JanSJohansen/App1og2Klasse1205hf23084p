
--create database FrugtDB
go
use FrugtDB
go
drop table Frugt
go
create table Frugt
(
   Id int primary key identity(1000, 1),
   [Name] nvarchar(25),
   Descr nvarchar(50),
   [Weight] int,
   Country nvarchar(25)
)
go
insert into Frugt values('Orange', 'Sur', 234, 'Orangeleans')
insert into Frugt values('Pear', 'Sur', 234, 'PearOrangeleans')
insert into Frugt values('Apple', 'Sur', 234, 'Appleoleans')
insert into Frugt values('Sydfrugt', 'Sur', 234, 'SouthOrleans')
insert into Frugt values('Banana', 'Sur', 234, 'Bananaleans')

select * from Frugt
