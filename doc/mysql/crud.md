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
```