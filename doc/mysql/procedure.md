```
-- change delimeter to make the whole procedure an entity
delimeter //
-- declare a procedure with 'create procedure'
-- 3 modes for params:
-- 1. IN, input param will be copy
-- 2. OUT, input param will be changed if changed in procedure
-- 3. INOUT, 
create procedure getAllEmployees(IN name varchar(100), OUT total int, INOUT count int)
begin
  -- declare a variable
  declare a, b varchar(100) default '';
  -- set value with 'set' or 'select ... into'
  set a = 'Hello';
  select count(*) into total from employees where emp_name = name;
  set count = count + total;
end //
delimeter ;

-- call the procedure
set @count = 2;
call getAllEmployees('Owen', @total, @count);
select @total;
select @count;

-- if else
delimeter //
create procedure getEmployeeLevel(IN id int, OUT level varchar(10))
begin
  declare salary int default 0;
  select emp_salary into salary from employees where emp_no = id;

  if salary > 30000 then
    set level = 'Manager';
  elseif ( salary > 20000 and salary <= 30000 ) then
    set level = 'Analyst';
  else
    set level = 'Vendor';
  end if;
end //
delimeter ;

-- case
case expression
  when condition1 then command;
  when condition2 then command;
  ...
  else command;
end case;

-- loop
while expression do
  ...
  ...
end while;

repeat
  ...
  ...
util expression
end repeat;

-- use cursor in format 'declare cursor_name cursor for select_statement;'
create procedure getEmailList(INOUT emails varchar(4000))
begin
  declare v_finished int default 0;
  declare v_email varchar(100) default '';

  -- declare a cursor
  declare email_cursor cursor for
  select email from employees;

  -- declare not found handler
  declare continue handler for NOT FOUND
  set v_finished = 1;

  -- open the cursor
  open email_cursor;

  -- loop the result set
  email_loop : loop
  fetch email_cursor into v_email;
  if v_finished = 1 then
    leave email_loop;
  end if;

  set emails = concat(v_email, ';', emails);
  end loop email_loop;

  -- close the cursor
  close email_cursor;
end

-- show procedures
show procedure status where name like '%employees%';
-- show procedures code
show create procedure getAllEmployees;

-- throw an exception
signal sqlstate '9500'
set message_text = 'exception happens';

-- create function
delimeter //
create function getEmployeeLevel(id int)  -- IN mode of param by default, others not allowed
  return varchar(100)  -- specify the return type
  deterministic  -- has to decide deterministic or not(same param has same result, then it's deterministic)

begin
  declare level varchar(100) default '';
  declare salary int default 0;

  select emp_salary into salary from employees where emp_no = id;
  if salary > 30000 then
    set level = 'Manager';
  else
    set level = 'Analyst';
  end if;

  -- specify return
  return level;
end //
delimeter ;

-- call the function
select emp_no, getEmployeeLevel(emp_no) from employees;
```