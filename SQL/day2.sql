create database fop14
go
use fop14;

-- constraints
create table admission
( 
	id int identity(101,1),
	name varchar(50) not null,
	contact numeric(10,0) unique not null,
	email varchar(80) null,
	fee money default 1000,
	mark int not null check(mark>=40 and mark<=100)
);

-- valid value
insert into admission(name, contact, email, fee, mark)
values('Tony', 9801200111, 'tony@stark.com', 2300.9, 67),
('Mark', 9801200112, 'mark@mark.com', 9000,45)

-- error in not null
insert into admission(contact, email, fee, mark)
values(9801200113, 'a@a.com',1200,99)

-- error in unique
insert into admission(name, contact, email, fee, mark)
values('Tony Singh', 9801200111, 'tony@stark.io', 2301.9, 68)


-- null case
insert into admission(name, contact, fee, mark)
values('Tony Singh', 9801200113, 2301.9, 68)

-- default
-- null case
insert into admission(name, contact, mark)
values('Tony Singh', 9801200114,  68)

-- check error
/*
insert into admission(name, contact, mark)
values('Tony Singh', 9801200115,  30)
*/

select * from admission


-- FK and PK

create table registerName
(
	id int identity(500, 5)primary key,
	name varchar(30)
)

insert into registerName(name) values('Ram'),('Shyam'),('Hari'),('Sita'),('Gita')

select * from registerName

create table team (
	id int foreign key references registerName(id),
	team varchar(30)
)

insert into team(id, team) values(505, 'football'),(510, 'cricket'),(505, 'chess')

--insert into team(id, team) values(105, 'football')



select * from team


-- join
create view myJoin as
select A.name, B.team 
from 
registerName A 
join 
team B
on 
A.id = B.id


select * from myJoin


-- procedure, trigger, exception handling


















