1. float, double, decimal
```
# columns definition
create table test (
  num1 float(5, 2) default null,
  num2 double(5, 2) default null,
  num3 decimal(5,2) default null
);

# insert rows
insert into test values(1.234, 1.25, 6.5412);
```
- add **(P, M)** to the type, P is the total length while M is the decimal length
- insert 1.235 into column would trunc the value in table to be 1.24 finally

2. enum type
```
# definition
create table test (
  name varchar(40),
  gender enum('Male', 'Female')
);

# insert rows
insert into test values('Owen', 'Male');
```

3. date related

type | byte | format | range
--- | --- | --- | ---
datetime | 8 bytes | YYYY-MM-DD HH:MM:SS | 1000-01-01 00:00:00 ~ 9999-12-31 23:59:59 
timestamp | 4 bytes | YYYY-MM-DD HH:MM:SS | 1970-01-01 00:00:01 ~ 2038 
date | 3 bytes | YYYY-MM-DD | 1000-01-01 ~ 9999-12-31 
year | 1 bytes | YYYY | 1901 ~ 2155

```
select now();
select curdate();
select sysdate();
select current_time();

set @dt='2018-09-10 07:15:30.123456';
select date(@dt);   -- 2018-09-10
select time(@dt);   -- 07:15:30.123456
...

```
note:
- mysql does not support mili-second, time support minimun second
- when inserting, value of the date related types shall be string, no need to use to_date() or some functions like oracle did
