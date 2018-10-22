create table
```
create table if not exists `employee` (
  `employee_id` int auto_increment,
  `name` varchar(100) not null,
  `title` varchar(150) not null,
  `age` tinyint not null,
  `entry_date` date,
  primary key(`employee_id`)
);

-- copy structure of countries
create table dup_countries like countries;

-- copy structure and data
create table if not exists dup_countries as
select * from countries;

-- with null check and range check
create table if not exists jobs
(
  job_id decimal not null,
  job_name varchar(100) not null,
  min_salary decimal(6, 0),
  max_salary decimal check(max_salary < 25000),
  primary key(job_id)
);

-- check string
create table if not exists countries
(
  country_id varchar(20),
  country_name varchar(100) check(country_name in ('India', 'China', 'Italy')),
  region_id decimal(10, 0),
  primary key(country_id)
);

-- date
create table if not exists job_history
(
  employee_id varchar(12) primary key not null,
  start_date date not null,
  end_date date not null check(end_date like '--/--/----'),
  job_id varchar(8) not null,
  depart_id varchar(8) not null
);

-- unique
create table if not exists countries
(
  country_id varchar(20),
  country_name varchar(100),
  unique(country_id)
);

-- default
create table if not exists jobs
(
  job_id varchar(10) not null unique,
  job_title varchar(100) not null default ' ',
  min_salary decimal(6, 0) default 8000,
  max_salary decimal(6, 0) default null
);

-- auto increment
create table if not exists employees
(
  emp_id integer not null primary key auto_increment,
  emp_name varchar(20) unique,
  country_name varchar(100) check(country_name in ('China', 'India', 'Italy')),
  min_salary decimal(6, 0) default 8000,
  job_id varchar(20) not null,
  foreign key(job_id) reference jobs(id)
) engin = InnoDB;
```
- not null: field not null
- auto_increment: value auto increment
- primary key

drop a table
```bash
drop table employee
```

table row operation
```
# insert a row
insert into employee(employee_id, name, title, age, entry_date) values ('1001', 'Owen', 'Analyst', '25', '2016-07-01');

# query a row
select * from employee;
select * from employee where employee_id = '1001';

alter table countries rename countries_new;

-- add column as the first column
alter table countries add cities_num first;

-- add column to specific position
alter table countries add leader varchar(20) after country_id;

-- change column type
alter table countries modify country_id int;
```