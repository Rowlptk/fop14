-- create database
create database dummy;

-- use
use dummy;

-- create table
create table students
(
	id int,
	name varchar(20)
)

-- view table
select * from students

-- insert values
insert into students(id,name)
values(101,'Tony Stark'),(102, 'Bruice Banner')

-- modify
alter table students add contact bigint;

-- update
update students
set contact = 9801200111
where id = 101;

select * from students

-- CRUD ==> Create ==> insert
-- Read ==> Select
--- Update
-- Delete


-- delete
delete from students where id = 102

-- modify ==> delete column
alter table students drop column contact

-- empty table
truncate table students

select * from students

-- delete table
drop table students

-- delete database
drop database dummy;





