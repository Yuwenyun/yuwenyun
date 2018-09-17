```bash
mysqladmin --version

# launch mysql
mysqld --console

# shut down mysql
mysqladmin shutdown

# connect to mysql server
mysql -u root -p

# show all the databases
show databases;

# switch to mysql db
use mysql

# show all the tables
show tables;

# show columns of a table
show columns from user;

# show index of a table
show index from user;

# create database
create database yuwenyun;

# drop database
drop database yuwenyun;
```

load sample data
```bash
mysql -u root -p -t < employees.sql
```
