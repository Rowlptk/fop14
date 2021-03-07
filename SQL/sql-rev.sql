-- create database
create database dummy;

-- use database
use dummy;

-- create table
create table students
(
	id int,
	name varchar(20)
)

-- view 
select * from students

-- insert
insert into students(id, name)
values(101, 'Tony Stark'),(102, 'Bruice Banner');

-- update
update students
set name = 'Iron Man'
where id = 101

select * from students

-- delete
delete from students where id = 102

-- empty table
truncate table students

-- delete table
drop table students

-- delete database
drop database dummy


-- constraints
/* 
sdASDC
aSCAS
*/
create database fop14v2

use fop14v2

create table herald_admit
(
	id int identity(101,1),
	name varchar(50) not null,
	contact numeric(10,0) unique not null,
	email varchar(80) null,
	fee money default 1000,
	mark int not null check(mark>=40 and mark<=100)
)

--select id, name from herald_admit
insert into herald_admit(name, contact, email, fee, mark)
values
('Tony',9801200110, 'tony@stark.com', 10000, 76),
('Mark', 9801200111, 'mark@mark.com', 9700, 78),
('Madhur', 9801200112, 'madhur@gmail.com', 6700, 86)

-- not null error
insert into herald_admit(contact, email, fee, mark)
values
(9801200113, 'tony@stark.com', 2000, 77)

-- error in unique
insert into herald_admit(name, contact, email, fee, mark)
values
('Aaloo',9801200110, 'tony@alloo.com', 3000, 66)

-- null
insert into herald_admit(name, contact, fee, mark)
values
('Aaloo',9801200114, 3000, 66)


-- default
insert into herald_admit(name, contact, mark)
values
('Ram',9801200115, 66)


-- check
insert into herald_admit(name, contact, mark)
values
('Shyam',9801200116, 28)

select * from herald_admit


-- Fk and Pk
create table nmc
(
	nmc_no int primary key,
	name varchar(30) not null
)

create table doctors
(
	nec_no int foreign key references nmc(nmc_no),
	hospital_name varchar(40)
) 

insert into nmc(nmc_no, name) values
(10002, 'Ram'),(10003, 'Shyam'),(10004,'Hari'),(10005, 'Sita'),(10006, 'Gita')

select * from nmc

insert into doctors(nec_no, hospital_name)
values(10002, 'Bir Aspatal'),
(10002,'Himalaya'),
(10003,'Teaching Hospital'),
(10005,'Alka'),
(10005,'Koshi'),
(10005,'Medanta')

select * from doctors




