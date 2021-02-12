
drop schema course_manager;
create schema course_manager;
use course_manager;
create table AdministratorAccounts (
	id varchar(24),
    lastname varchar(30),
    firstname varchar(30),
    username varchar(30),
    password varchar(30)
);

insert into AdministratorAccounts(id, lastname, firstname, username, password)
values ('101', 'Doe', 'John', 'admin', 'pass'),
('102', 'eye', 'hawk', 'herald', 'pass123');


select * from AdministratorAccounts;

create table InstructorAccounts (
	id varchar(24),
    lastname varchar(30),
    firstname varchar(30),
    username varchar(30),
    password varchar(30)
);

insert into InstructorAccounts(id, lastname, firstname, username, password)
values ('101', 'Prasad', 'Ram', 'ram', 'pass'),
('102', 'Khadka', 'Hari', 'hari', 'pass123');


select * from InstructorAccounts;

create table StudentAccounts (
	id varchar(24),
    lastname varchar(30),
    firstname varchar(30),
    username varchar(30),
    password varchar(30)
);

insert into StudentAccounts(id, lastname, firstname, username, password)
values ('101', 'Bist', 'Madhur', 's1', 'pass'),
('102', 'Stark', 'Tony', 's2', 'pass2');


select * from StudentAccounts;

create table course (
	course_id int auto_increment primary key,
    course_code varchar(10) not null,
    course_name varchar(50) not null,
    course_sem int not null,
    is_active int default 1
);

select * from course;

create table modules (
	course_id int,
    module_id int auto_increment primary key,
    module_sem int check(module_sem>0 and module_sem<9),
    module_name varchar(50),
	FOREIGN KEY (course_id) REFERENCES course(course_id) on update cascade on delete cascade
);

select * from modules;


insert into course(course_code,course_name,course_sem)
values('BIT', 'Bachelor In Information Technology', 8);

insert into modules(course_id,module_sem,module_name)
values(1, 1, 'C Programming'),(1, 1, 'JAVA'),(1, 1, 'Web Development'),(1, 1, 'DBMS');


create table studentRegisterForCourse
(
	reg_id int auto_increment primary key,
    student_id int not null,
    course_id int not null,
    student_contact bigint unique not null,
    student_address varchar(100),
    current_sem int default 1,
    student_table_name varchar(30),
    FOREIGN KEY (course_id) REFERENCES course(course_id) on update cascade on delete cascade
);

select * from studentRegisterForCourse
;
select * from StudBEX101;

create table instuctor_module
(
	instructor_id int,
    course_id int,
    module_id int
);

-- insert into StudBEX101(student_id, module_id, module_sem) values(101, 13, 1);-- 

-- delete C from course C inner join modules M on C.course_id = M.course_id where C.course_id = 1;



-- delimiter //
-- create procedure deleteCourseWithModules(in courseid int)
-- begin
-- set foreign_key_checks = 0;
-- delete from course where course_id = courseid;
-- set foreign_key_checks = 1;

-- delete from modules where course_id = courseid;
-- end //
-- delimiter ;

-- call deleteCourseWithModules(101);

