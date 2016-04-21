use lab5;
drop table if exists student;
drop table if exists course;

-- Question 1
create table student (
studentID varchar(9),
studentName varchar(100),
dateOfBirth datetime,
primary key(studentID));

create table course(
courseCode varchar(5),
courseName varchar(100),
primary key (courseCode));

-- Question 2
alter table student add(
courseCode varchar(5));

-- Question 3
alter table student
add constraint foreign key(courseCode) references course(courseCode);

-- Question 4
alter table student add(
address text);

-- Question 5
alter table student modify
studentName varchar(70);

-- Question 6
alter table student drop
column dateOfBirth;

-- alter table student drop column age;

-- Question 7
alter table student add
age int default 18;

-- Question 8
alter table student add constraint
age_check check(age>=17);

-- Question 9
insert into course values('BN001','Engineering');
insert into course values('BN002','Computing');
insert into course values('BN003','Maths');

select courseCode, courseName from course;

insert into student values
('B00357483','Frank Mah','BN002','12 ryegrove, Longford', '18');
insert into student values
('B00355663','Keith Brown','BN001','52 southend vale, Cork', '19');
insert into student values
('B00353572','Rusty Shackleford','BN003','1 Beechwood, Kildare', '20');

select * from student;

-- Question 10
update student set courseCode = 'BN002';

select * from student;

select * from course;